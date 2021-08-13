import java.util.Arrays;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxLength = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    maxLength = Math.max(maxLength, dp[j] + 1);
            }
            dp[i] = maxLength;
        }
        int res = 0;
        for (int n : dp) {
            res = Math.max(res, n);
        }
        return res;
    }
}
