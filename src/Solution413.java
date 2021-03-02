public class Solution413 {
    // [1,2,3,4,5]
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length< 3) return 0;
        int[] dp = new int[nums.length - 2];
        if (nums[1] - nums[0] == nums[2] - nums[1])
            dp[0] = 1;
        else
            dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            if (nums[i + 2] - nums[i + 1] == nums[i + 1] - nums[i]) {
                if (nums[i + 1] - nums[i] == nums[i] - nums[i - 1]) {
                    dp[i] += dp[i - 1] + 1;
                } else {
                    dp[i] = 1;
                }
            }
        }
        int sum = 0;
        for (int j : dp) {
            sum += j;
        }
        return sum;
    }
}
