/**/
package algorithm.JzOffer.Jz37.Jz36;

//Definition for a Node.

// Definition for a Node.

import algorithm.DataStructure.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    StringBuilder sb;
    String[] data;
    int id;

    public static void main(String[] args) {
        var t = new Codec().deserialize("1,2,#,#,3,4,#,#,5,#,#");
        var t1 = new Codec().serialize(t);
        System.out.println(t1);
    }

    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        dfsS(root);
        return sb.toString();
    }

    void dfsS(TreeNode root) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        dfsS(root.left);
        dfsS(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        this.data = data.split(",");
        id = 0;
        return dfsD();
    }

    TreeNode dfsD() {
        var s = data[id++];
        if (s.equals("#"))
            return null;
        var val = Integer.parseInt(s);
        return new TreeNode(val, dfsD(), dfsD());
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));