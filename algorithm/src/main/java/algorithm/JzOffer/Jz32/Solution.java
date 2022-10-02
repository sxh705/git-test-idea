/**/
package algorithm.JzOffer.Jz32;

/**/

import algorithm.DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public int[] levelOrder(TreeNode root) {
        dfs(root, 0);
        int siz = 0;
        for (var x : res) siz += x.size();
        var ans = new int[siz];
        int i = 0;
        for (var x : res)
            for (var y : x) ans[i++] = y;
        return ans;
    }

    void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (res.size() - 1 < depth) res.add(new ArrayList<>());
        res.get(depth).add(root.val);
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }


}