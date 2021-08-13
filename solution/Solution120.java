import java.util.List;

public class Solution120 {

    // backtrack version, TLE
//    private int minLength = Integer.MAX_VALUE, currLength = 0;
//
//    //  1
//    // 2 3
//    public int minimumTotal(List<List<Integer>> triangle) {
//        backtrack(triangle, 0, 0);
//        return minLength;
//    }
//
//    private void backtrack(List<List<Integer>> triangle, int currLevel, int index) {
//        currLength += triangle.get(currLevel).get(index);
//        currLevel++;
//        if (currLevel == triangle.size()) {
//            minLength = Math.min(minLength, currLength);
//        } else {
//            backtrack(triangle, currLevel, index);
//            backtrack(triangle, currLevel, index + 1);
//        }
//        currLength -= triangle.get(currLevel - 1).get(index);
//    }


    // DP version
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int n = triangle.size();
//        if (n == 1) return triangle.get(0).get(0);
//        int[][] dp = new int[n][n];
//        dp[0][0] = triangle.get(0).get(0);
//        int minLength = Integer.MAX_VALUE;
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j <= i; j++) {
//                if (j == 0) {
//                    dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
//                } else if (j == i) {
//                    dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
//                } else {
//                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
//                }
//                if (i == n - 1) minLength = Math.min(minLength, dp[i][j]);
//            }
//        }
//        return minLength;
//    }

    // optimized DP version, Space Complexity is O(n)
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        if (n == 1) return dp[0];
        int minLength = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == i) {
                    dp[j] = dp[j - 1] + triangle.get(i).get(j);
                } else if (j == 0) {
                    dp[j] = dp[0] + triangle.get(i).get(j);
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
                }
                if (i == n - 1) minLength = Math.min(minLength, dp[j]);
            }
        }
        return minLength;
    }
}
