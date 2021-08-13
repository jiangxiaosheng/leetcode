public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    if (j == 0 && i == 0) {
                        dp[j] = 1;
                    } else if (j == 0) {
                    } else if (i == 0) {
                        dp[j] = dp[j - 1];
                    } else {
                        dp[j] += dp[j - 1];
                    }
                }
            }
        }
        return dp[n - 1];
    }
}
