public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) nums[i] = n + 1;
        }
        for (int i = 0; i < nums.length; i++) {
            int x = Math.abs(nums[i]);
            if (x <= n)
                nums[x - 1] = -Math.abs(nums[x - 1]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                return i + 1;
        }
        return n + 1;
    }
}
