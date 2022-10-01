/**/
package algorithm.JzOffer.Jz27;

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
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        mirrorTree(root.left);
        mirrorTree(root.right);
        swap(root);
        return root;
    }

    void swap(TreeNode root) {
        var t = root.left;
        root.left = root.right;
        root.right = t;
    }

}