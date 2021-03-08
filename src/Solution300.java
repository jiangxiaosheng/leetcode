public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0; dp[1] = 1;
        int maxLength = 0;
        for (int i = 2; i < dp.length; i++) {
            if (nums[i - 1] > nums[i - 2])
                dp[i] = dp[i - 1];
        }
    }
}
