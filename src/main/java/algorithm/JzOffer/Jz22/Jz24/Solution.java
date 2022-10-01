/**/
package algorithm.JzOffer.Jz22.Jz24;

import algorithm.DataStructure.ListNode;
/**/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode now = null;
        ListNode next = head;
        if (head == null || head.next == null)
            return head;
        while (next != null) {
            ListNode nextNext = next.next;
            next.next = now;
            now = next;
            next = nextNext;
        }
        return now;
    }
}