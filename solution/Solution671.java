public class Solution671 {

    int ans = Integer.MAX_VALUE, rootval;
    boolean inf = false;

    public int findSecondMinimumValue(TreeNode root) {
        rootval = root.val;
        dfs(root);
        if (ans == Integer.MAX_VALUE && !inf) return -1;
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root.val > rootval) {
            ans = Math.min(ans, root.val);
            if (root.val == Integer.MAX_VALUE)
                inf = true;
        }
        if (root.left == null) return;
        dfs(root.left);
        dfs(root.right);
    }
}
