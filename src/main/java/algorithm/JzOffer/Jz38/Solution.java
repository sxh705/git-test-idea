/**/
package algorithm.JzOffer.Jz38;

import java.util.HashSet;
import java.util.Set;
/**/


class Solution {
    StringBuilder sb;
    Set<String> ans;

    public String[] permutation(String s) {
        ans = new HashSet<>();
        sb = new StringBuilder(s);
        dfs(0);
        return ans.toArray(String[]::new);
    }

    void dfs(int id) {
        if (id == sb.length() - 1) {
            ans.add(sb.toString());
            return;
        }
        for (int i = id; i < sb.length(); i++) {
            swap(id, i);
            dfs(id + 1);
            swap(id, i);
        }
    }

    void swap(int l, int r) {
        if (l == r)
            return;
        char t = sb.charAt(l);
        sb.setCharAt(l, sb.charAt(r));
        sb.setCharAt(r, t);
    }

}