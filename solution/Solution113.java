import java.util.ArrayList;
import java.util.List;

public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(root, targetSum, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> res) {
        if (root == null) return;
        path.add(root.val);
        if (root.val == targetSum && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        backtrack(root.left, targetSum - root.val, path, res);
        backtrack(root.right, targetSum - root.val, path, res);
        path.remove(path.size() - 1);
    }
}
