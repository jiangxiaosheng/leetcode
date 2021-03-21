import java.util.HashMap;
import java.util.Map;

public class Solution594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(), value = entry.getValue();
            if (map.containsKey(key + 1))
                max = Math.max(map.get(key + 1) + map.get(key), max);
        }
        return max;
    }
}
