public class Solution343 {
    public int integerBreak(int n) {
        if (n < 2) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            int currMax = 0;
            for (int j = i - 1; j >= 1; j--) {
                currMax = Math.max(Math.max(j * (i - j), dp[j] * (i - j)), currMax);
            }
            dp[i] = currMax;
        }
        return dp[n];
    }

    // TODO: to be optimized
}
