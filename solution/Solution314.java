import java.util.*;

public class Solution314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        // column-row
        Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();
        Map<TreeNode, int[]> pos = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        pos.put(root, new int[]{0, 0});
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                int[] p = pos.get(node);
                if (!map.containsKey(p[0])) map.put(p[0], new HashMap<>());
                List<Integer> t = map.get(p[0]).getOrDefault(p[1], new ArrayList<>());
                t.add(node.val);
                map.get(p[0]).put(p[1], t);
                if (node.left != null) {
                    queue.offer(node.left);
                    pos.put(node.left, new int[]{p[0] - 1, p[1] + 1});
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    pos.put(node.right, new int[]{p[0] + 1, p[1] + 1});
                }
            }
        }
        for (int i = -100; i <= 100; i++) {
            if (map.containsKey(i)) {
                List<Integer> col = new ArrayList<>();
                res.add(col);
                for (int j = 0; j <= 100; j++) {
                    if (map.get(i).containsKey(j)) {
                        col.addAll(map.get(i).get(j));
                    }
                }
            }
        }
        return res;
    }
}
