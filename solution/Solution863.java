import java.util.*;

public class Solution863 {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        findParents(root, parents);
        List<Integer> res = new ArrayList<>();
        dfs(res, parents, null, target, 0, k);
        return res;
    }

    private void findParents(TreeNode root, Map<TreeNode, TreeNode> parents) {
        if (root.left != null) {
            parents.put(root.left, root);
            findParents(root.left, parents);
        }
        if (root.right != null) {
            parents.put(root.right, root);
            findParents(root.right, parents);
        }
    }

    private void dfs(List<Integer> res, Map<TreeNode, TreeNode> parents, TreeNode from, TreeNode root, int depth, int k) {
        if (root == null) return;
        if (depth == k) {
            res.add(root.val);
            return;
        }
        if (from != parents.get(root)) {
            dfs(res, parents, root, parents.get(root), depth + 1, k);
        }
        if (from != root.left) {
            dfs(res, parents, root, root.left, depth + 1, k);
        }
        if (from != root.right) {
            dfs(res, parents, root, root.right, depth + 1, k);
        }
    }
}
