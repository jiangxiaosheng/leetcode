import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution508 {

    Map<Integer, Integer> freqs = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        int maxFreq = 0;
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pair : freqs.entrySet()) {
            int key = pair.getKey(), value = pair.getValue();
            if (value > maxFreq) {
                maxFreq = value;
                res.clear();
                res.add(key);
            } else if (value == maxFreq) {
                res.add(key);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int sum = root.val;
        sum += dfs(root.left);
        sum += dfs(root.right);
        freqs.put(sum, freqs.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
