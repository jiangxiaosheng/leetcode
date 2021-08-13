import java.util.ArrayList;
import java.util.List;

public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversalHelper(res, root);
        return res;
    }

    private void traversalHelper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        traversalHelper(res, root.left);
        res.add(root.val);
        traversalHelper(res, root.right);
    }
}
