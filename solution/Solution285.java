import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            p = p.right;
            while (p.left != null) p = p.left;
            return p;
        }
        boolean flag = false;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            if (root != null && p.val >= root.val) root = root.right;
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.empty()) return null;
            root = stack.pop();
            if (flag) return root;
            if (root.val == p.val) {
                flag = true;
            }
            root = root.right;
        }
        return null;
    }
}
