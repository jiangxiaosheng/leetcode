class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Solution116 {
    public Node connect(Node root) {
        helper(root);
        return root;
    }

    private void helper(Node root) {
        if (root == null) return;
        helper(root.left);
        helper(root.right);
        Node r1 = root.left, r2 = root.right;
        while (r1 != null) {
            r1.next = r2;
            r1 = r1.right;
            r2 = r2.left;
        }
    }

}
