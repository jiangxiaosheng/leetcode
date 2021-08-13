import java.util.ArrayList;
import java.util.List;

public class Solution298 {

    int longest = 1;

    public int longestConsecutive(TreeNode root) {
        List<TreeNode> path = new ArrayList<>();
        path.add(new TreeNode(Integer.MIN_VALUE));
        dfs(root, path, 1);
        return longest;
    }

    private void dfs(TreeNode root, List<TreeNode> path, int curr) {
        if (root == null) return;
        if (root.val == path.get(path.size() - 1).val + 1) {
            curr++;
            longest = Math.max(curr, longest);
        } else {
            curr = 1;
        }
        path.add(root);
        dfs(root.left, path, curr);
        dfs(root.right, path, curr);
        path.remove(path.size() - 1);
    }
}
