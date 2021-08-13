import java.util.Arrays;

public class Solution313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int[] p = new int[primes.length];
        Arrays.fill(p, 1);
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * dp[p[j]]);
            }
            for (int j = 0; j < primes.length; j++) {
                if (primes[j] * dp[p[j]] == min) p[j]++;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
