public class Solution337 {
    // TODO
//    public int rob(TreeNode root) {
//        if (root == null) return 0;
//        int maxValue = root.val;
//        if (root.left != null) {
//            maxValue += dfs(root.left, root.val, 0);
//        }
//        if (root.right != null) {
//            maxValue += dfs(root.right, root.val, 0);
//        }
//        return maxValue;
//    }
//
//    private int dfs(TreeNode root, int prev, int preprev) {
//        if (root == null) return 0;
//        int value = Math.max(root.val + preprev, prev), t = value;
//        value += dfs(root.left, t, prev);
//        value += dfs(root.right, t, prev);
//        return value;
//    }
}
