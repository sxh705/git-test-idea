/**/
package algorithm.JzOffer.Jz22;

import algorithm.DataStructure.ListNode;
/**/

class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        var p1 = head;
        var p2 = head;
        for (int i = 0; i < k; i++) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
    }
}