import java.util.*;

public class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        return buildHelper(1, n);
    }

    private List<TreeNode> buildHelper(int min, int max) {
        List<TreeNode> res = new ArrayList<>();
        if (min > max) {
            res.add(null);
            return res;
        }

        for (int i = min; i <= max; i++) {
            List<TreeNode> left = buildHelper(min, i - 1);
            List<TreeNode> right = buildHelper(i + 1, max);
            for (TreeNode leftRoot : left) {
                for (TreeNode rightRoot : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftRoot;
                    root.right = rightRoot;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
