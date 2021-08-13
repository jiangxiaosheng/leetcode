import java.util.HashMap;
import java.util.Map;

public class Solution1711 {
    public int countPairs(int[] deliciousness) {
        int mod = 1000000007;
        int maxVal = 0;
        for (int i : deliciousness) {
            maxVal = Math.max(maxVal, i);
        }
        int maxSum = maxVal * 2;
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int n : deliciousness) {
            for (int m = 1; m <= maxSum; m = m * 2) {
                cnt = (cnt + map.getOrDefault(m - n, 0)) % mod;
            }
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return cnt;
    }
}
