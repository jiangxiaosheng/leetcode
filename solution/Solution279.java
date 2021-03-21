public class Solution279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int minCount = Integer.MAX_VALUE;
           for (int j = 1; j * j <= i; j++) {
               minCount = Math.min(minCount, dp[i - j * j] + 1);
           }
           dp[i] = minCount;
        }
        return dp[n];
    }
}
