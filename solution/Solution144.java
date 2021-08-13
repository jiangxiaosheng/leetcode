import java.util.ArrayList;
import java.util.List;

public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        travel(res, root);
        return res;
    }

    private void travel(List<Integer> res, TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        travel(res, root.left);
        travel(res, root.right);
    }
}
