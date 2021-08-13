import java.util.ArrayList;
import java.util.List;

public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        travel(res, root);
        return res;
    }

    private void travel(List<Integer> res, TreeNode root) {
        if (root == null) return;
        travel(res, root.left);
        travel(res, root.right);
        res.add(root.val);
    }
}
