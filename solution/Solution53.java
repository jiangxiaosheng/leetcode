public class Solution53 {
    // divide and conquer version
    // [-2,1,-3,4,-1,2,1,-5,4]
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return maxSubArrayHelper(nums, 0, nums.length - 1);
    }

    private int maxSubArrayHelper(int[] nums, int i, int j) {
        if (i > j) return Integer.MIN_VALUE;
        if (i == j) return nums[i];
        int mid = (i + j) / 2;
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE, sum = 0;
        for (int index = mid - 1; index >= i; index--) {
            sum += nums[index];
            if (sum > leftMax)
                leftMax = sum;
        }
        sum = 0;
        for (int index = mid + 1; index <= j; index++) {
            sum += nums[index];
            if (sum > rightMax)
                rightMax = sum;
        }
        int thisValue = Math.max(leftMax, 0) + Math.max(rightMax, 0) + nums[mid];
        return Math.max(maxSubArrayHelper(nums, i, mid - 1), Math.max(maxSubArrayHelper(nums, mid + 1, j), thisValue));
    }

    // TODO: DP version
//    public int maxSubArray(int[] nums) {
//
//    }
}
