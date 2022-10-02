/**/
package algorithm.JzOffer.Jz35;

import java.util.HashMap;
import java.util.Map;

//Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

/**/

class Solution {
    Map<Node, Node> mem2New = new HashMap<>();

    public Node copyRandomList(Node head) {
        var t = head;
        var ans = new Node(10);
        var tNew = ans;
        while (t != null) {
            tNew.next = new Node(t.val);
            mem2New.put(t, tNew.next);
            tNew = tNew.next;
            t = t.next;
        }
        t = head;
        while (t != null) {
            mem2New.get(t).random = mem2New.get(t.random);
            t = t.next;
        }
        return ans.next;
    }
}