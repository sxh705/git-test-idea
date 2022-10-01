/**/
package algorithm.JzOffer.Jz36;

//Definition for a Node.

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

class Solution {
    Node nowPtr;

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        nowPtr = new Node(Integer.MIN_VALUE);
        var head = nowPtr;
        dfs(root);
        nowPtr.right = head.right;
        head.right.left = nowPtr;
        return head.right;
    }

    void dfs(Node root) {
        if (root == null)
            return;
        dfs(root.left);
        nowPtr.right = root;
        root.left = nowPtr;
        nowPtr = root;
        dfs(root.right);
    }
}