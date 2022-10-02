/**/
package algorithm.JzOffer.Jz18;

import algorithm.DataStructure.ListNode;
/**/

class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        var p = head;
        if (p.val == val) {
            return p.next;
        }
        while (p.next.val != val) {
            p = p.next;
        }
        p.next = p.next.next;
        return head;
    }
}