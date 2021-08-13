public class Solution1277 {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, cnt = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                    cnt += dp[i][j];
                    continue;
                }
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    cnt += dp[i][j];
                }
            }
        }
        return cnt;
    }
}
