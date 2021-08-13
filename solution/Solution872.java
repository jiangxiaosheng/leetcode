import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>(), leaves2 = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>(), stack2 = new Stack<>();
        while (!stack1.empty() || root1 != null) {
            while (root1 != null) {
                stack1.push(root1);
                if (root1.left == null && root1.right == null) leaves1.add(root1.val);
                root1 = root1.left;
            }
            root1 = stack1.pop().right;
        }
        while (!stack2.empty() || root2 != null) {
            while (root2 != null) {
                stack2.push(root2);
                if (root2.left == null && root2.right == null) leaves2.add(root2.val);
                root2 = root2.left;
            }
            root2 = stack2.pop().right;
        }
        return leaves1.equals(leaves2);
    }
}
