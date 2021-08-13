import java.util.ArrayList;
import java.util.List;

public class Solution264 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int n2 = dp[p2] * 2, n3 = dp[p3] * 3, n5 = dp[p5] * 5;
            int v = Math.min(Math.min(n2, n3), n5);
            dp[i] = v;
            if (v == n2) {
                p2++;
            } else if (v == n3) {
                p3++;
            } else {
                p5++;
            }
        }
        return dp[n];
    }
}
