public class Solution70 {
//    public int climbStairs(int n) {
//        if (n <= 1) return 1;
//        int[] dp = new int[n + 1];
//        dp[0] = 1;
//        dp[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        return dp[n];
//    }

    // optimized version, the space complexity can be reduced to O(1)
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        int prev = 1, curr = 1, temp;
        for (int i = 0; i <= n - 2; i++) {
            temp = curr;
            curr = curr + prev;
            prev = temp;
        }
        return curr;
    }
}
