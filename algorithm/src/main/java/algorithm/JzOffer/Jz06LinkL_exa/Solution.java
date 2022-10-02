/**/
package algorithm.JzOffer.Jz06LinkL_exa;


import algorithm.DataStructure.ListNode;

import java.util.ArrayList;
/**/

class Solution {
    ArrayList<Integer> al = new ArrayList<Integer>();

    public int[] reversePrint(ListNode head) {
        var ans = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            ans[i] = al.get(i);
        }
        return ans;
    }

    void dfs(ListNode x) {
        if (x == null)
            return;
        dfs(x.next);
        al.add(x.val);
    }
}