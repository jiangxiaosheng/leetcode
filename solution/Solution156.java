public class Solution156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        return reverseHelper(root);
    }

    private TreeNode reverseHelper(TreeNode root) {
        if (root == null || root.left == null) return root;
        TreeNode p = root.left, newRoot = reverseHelper(p);
        p.left = root.right;
        p.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
