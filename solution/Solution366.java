import java.util.ArrayList;
import java.util.List;

public class Solution366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        while (root.left != null || root.right != null) {
            List<Integer> level = new ArrayList<>();
            dfs(level, root);
            res.add(level);
        }
        List<Integer> level = new ArrayList<>();
        level.add(root.val);
        res.add(level);
        return res;
    }

    private void dfs(List<Integer> level, TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left, right = root.right;
        boolean flagL = left != null && left.left == null && left.right == null,
                flagR = right != null && right.left == null && right.right == null;
        dfs(level, root.left);
        if (flagL) {
            root.left = null;
            level.add(left.val);
        }
        dfs(level, root.right);
        if (flagR) {
            root.right = null;
            level.add(right.val);
        }
    }
}
