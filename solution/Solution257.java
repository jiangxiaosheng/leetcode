import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution257 {
    // dfs version
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        dfs(res, new ArrayList<>(), root);
        return res;
    }

    private void dfs(List<String> res, List<TreeNode> path, TreeNode root) {
        if (root == null) {
            return;
        }
        path.add(root);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i).val).append("->");
            }
            sb.append(path.get(path.size() - 1).val);
            res.add(sb.toString());
        } else {
            dfs(res, path, root.left);
            dfs(res, path, root.right);
        }
        path.remove(path.size() - 1);
    }

}
