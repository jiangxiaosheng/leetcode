public class Solution687 {

    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftLongest = longestUnivaluePath(root.left), rightLongest = longestUnivaluePath(root.right);
        int l = 0, r = 0;
        if (root.left != null && root.left.val == root.val) {
            l = leftLongest + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            r = rightLongest + 1;
        }
        max = Math.max(max, l + r);
        return Math.max(l, r);
    }
}
