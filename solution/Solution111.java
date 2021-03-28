public class Solution111 {
    public int minDepth(TreeNode root) {
        return minDepthHelper(root);
    }

    private int minDepthHelper(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return minDepthHelper(root.right) + 1;
        if (root.right == null) return minDepthHelper(root.left ) + 1;
        int leftMin = minDepthHelper(root.left);
        int rightMin = minDepthHelper(root.right);
        return Math.min(leftMin, rightMin) + 1;
    }
}
