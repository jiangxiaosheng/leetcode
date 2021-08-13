public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length, len = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || i == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                    len = Math.max(len, dp[i][j]);
                    continue;
                }
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                    len = Math.max(len, dp[i][j]);
                }
            }
        }
        return len * len;
    }
}
