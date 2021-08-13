import java.util.*;

public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> level = new ArrayList<>();
        level.add(root.val);
        res.add(new ArrayList<>(level));
        while (true) {
            int size = queue.size();
            boolean next = false;
            TreeNode curr;
            level.clear();
            for (int i = 0; i < size; i++) {
                curr = queue.poll();
                if (curr.left != null) {
                    next = true;
                    level.add(curr.left.val);
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    next = true;
                    level.add(curr.right.val);
                    queue.offer(curr.right);
                }
            }
            if (!next) break;
            res.add(new ArrayList<>(level));
        }
        Collections.reverse(res);
        return res;
    }
}
