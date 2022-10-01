/**/
package algorithm.JzOffer.Jz34;

import algorithm.DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
/**/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> pathNow = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return ans;
    }

    void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                pathNow.add(root.val);
                ans.add(List.copyOf(pathNow));
                pathNow.remove(pathNow.size() - 1);
            }
            return;
        }
        pathNow.add(root.val);
        dfs(root.left, target - root.val);
        dfs(root.right, target - root.val);
        pathNow.remove(pathNow.size() - 1);
    }
}