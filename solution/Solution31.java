import java.util.Arrays;

public class Solution31 {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) return;
        int l = -1;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                l = i - 1;
                break;
            }
        }
        if (l == -1) {
            Arrays.sort(nums);
            return;
        }
        int min = Integer.MAX_VALUE, r = l + 1;
        for (int i = nums.length - 1; i > l; i--) {
            if (nums[i] > nums[l] && nums[i] < min) {
                r = i;
                min = nums[i];
            }
        }
        swap(nums, l, r);
        Arrays.sort(nums, l + 1, nums.length);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[j];
        nums[j] = nums[i];
        nums[i] = t;
    }
}
