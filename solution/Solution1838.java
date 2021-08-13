import java.util.Arrays;

public class Solution1838 {
    // TODO
    // [1,2,4] 5
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 1, l = 0;
        long total = 0;
        for (int r = 1; r < n; r++) {
            total += (long) (nums[r] - nums[r - 1]) * (r - l);
            while (total > k) {
                total -= nums[r] - nums[l];
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
