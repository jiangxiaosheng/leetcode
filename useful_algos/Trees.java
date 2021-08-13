import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Trees {
    List<Integer> preOrderTravelIterate(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                res.add(root.val);
                root = root.left;
            }
            root = stack.pop().right;
        }
        return res;
    }

    List<Integer> inOrderTravelIterate(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    List<Integer> postOrderTravelIterate(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                res.add(root.val);
                root = root.right;
            }
            root = stack.pop().left;
        }
        Collections.reverse(res);
        return res;
    }
}
