public class Solution114 {

    static class NodePair {
        TreeNode root, tail;

        NodePair(TreeNode r, TreeNode t) {
            root = r;
            tail = t;
        }
    }

    public void flatten(TreeNode root) {
        helper(root);
    }

    private NodePair helper(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return new NodePair(root, root);
        NodePair left = helper(root.left);
        NodePair right = helper(root.right);
        root.left = null;
        if (left == null) {
            root.right = right.root;
            return new NodePair(root, right.tail);
        } else if (right == null) {
            root.right = left.root;
            return new NodePair(root, left.tail);
        } else {
            root.right = left.root;
            left.tail.right = right.root;
            return new NodePair(root, right.tail);
        }
    }
}
