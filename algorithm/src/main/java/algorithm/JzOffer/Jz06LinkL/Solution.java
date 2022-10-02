/**/
package algorithm.JzOffer.Jz06LinkL;

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
    public int[] reversePrint(ListNode head) {
        int len = 0;
        var p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        var ans = new int[len];
        p = head;
        while (p != null) {
            len--;
            ans[len] = p.val;
            p = p.next;
        }
        return ans;
    }
}