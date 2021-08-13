public class Solution404 {

    int sum;

    public int sumOfLeftLeaves(TreeNode root) {
        helper(root);
        return sum;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        if (root.left != null && (root.left.left == null && root.left.right == null)) {
            sum += root.left.val;
        }
        helper(root.left);
        helper(root.right);
    }
}
