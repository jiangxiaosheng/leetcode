import java.util.Arrays;

public class Solution45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int minTimes = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] == -1) continue;
                if (j + nums[j] >= i)
                    minTimes = Math.min(minTimes, dp[j] + 1);
            }
            dp[i] = minTimes;
        }
        return dp[n - 1];
    }
}
