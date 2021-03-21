public class Solution213 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }

    private int robHelper(int[] nums, int i, int j) {
        if (i == j) return nums[i];
        int[] dp = new int[j - i + 2];
        dp[1] = nums[i];
        for (int index = i + 2; index <= j + 1; index++) {
            dp[index - i] = Math.max(dp[index - i - 1], dp[index - i - 2] + nums[index - 1]);
        }
        return dp[j - i + 1];
    }
}
