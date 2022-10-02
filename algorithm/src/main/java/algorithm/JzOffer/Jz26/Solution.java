/**/
package algorithm.JzOffer.Jz26;

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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        return isSub(A, B);
    }

    boolean isSub(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        } else if (A == null) {
            return false;
        }
        if (isSub(A.left, B) || isSub(A.right, B)) {
            return true;
        }
        if (A.val == B.val) {
            return isEqual(A, B);
        }
        return false;
    }

    boolean isEqual(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        } else if (A == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }
        return isEqual(A.left, B.left) && isEqual(A.right, B.right);
    }

}