/**/
package algorithm.JzOffer.Jz07TreeNode;

import algorithm.DataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;
/**/

class Solution {
    int[] pre;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        for (int i = 0; i < inorder.length; i++)
            inorderMap.put(inorder[i], i);
        return dfs(0, pre.length - 1, 0, inorder.length - 1);
    }

    TreeNode dfs(int l1, int r1, int l2, int r2) {
        if (l1 == r1) return new TreeNode(pre[l1]);
        if (l1 > r1) return null;
        int root = pre[l1];
        int len = inorderMap.get(root) - l2;
        return ConStructNode(root,
                dfs(l1 + 1, l1 + len, l2, l2 + len),
                dfs(l1 + len + 1, r1, l2 + len + 1, r2));
    }

    TreeNode ConStructNode(int root, TreeNode l, TreeNode r) {
        TreeNode ans = new TreeNode(root);
        ans.left = l;
        ans.right = r;
        return ans;
    }
}