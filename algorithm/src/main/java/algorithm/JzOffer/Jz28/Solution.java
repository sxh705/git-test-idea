/**/
package algorithm.JzOffer.Jz28;

import algorithm.DataStructure.TreeNode;
/**/

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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        } else if (l != null && r != null) {
            return l.val == r.val
                    && isSymmetric(l.left, r.right)
                    && isSymmetric(l.right, r.left);
        }
        return false;
    }
}