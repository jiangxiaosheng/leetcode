import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution236 {
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        List<TreeNode> pathp = dfs(new ArrayList<>(), root, p), pathq = dfs(new ArrayList<>(), root, q);
//        TreeNode ancestor = null;
//        for (int i = 0; i < Math.min(pathp.size(), pathq.size()); i++) {
//            if (pathp.get(i) == pathq.get(i)) {
//                ancestor = pathp.get(i);
//            } else {
//                break;
//            }
//        }
//        return ancestor;
//    }
//
//    private List<TreeNode> dfs(List<TreeNode> path, TreeNode root, TreeNode target) {
//        if (root == null) return null;
//        path.add(root);
//        if (root == target) {
//            return new ArrayList<>(path);
//        } else {
//            List<TreeNode> tl = dfs(path, root.left, target);
//            if (tl != null) return tl;
//            List<TreeNode> tr = dfs(path, root.right, target);
//            if (tr != null) return tr;
//            path.remove(path.size() - 1);
//            return null;
//        }
//    }

    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    // improved version
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean fl = dfs(root.left, p, q), fr = dfs(root.right, p, q);
        if ((fl && fr) || ((root == p || root == q) && (fl || fr))) {
            ans = root;
        }
        return root == p || root == q || fl || fr;
    }
}
