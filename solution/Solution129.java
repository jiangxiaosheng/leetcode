import java.util.ArrayList;
import java.util.List;

public class Solution129 {

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(new ArrayList<>(), root);
        return sum;
    }

    private void dfs(List<Integer> path, TreeNode root) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            int t = 0;
            for (int i : path) {
                t = 10 * t + i;
            }
            sum += t;
        } else {
            dfs(path, root.left);
            dfs(path, root.right);
        }
        path.remove(path.size() - 1);
    }
}
