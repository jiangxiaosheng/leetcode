import java.util.Arrays;

public class Solution280 {
    public void wiggleSort(int[] nums) {
        boolean less = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (less) {
                if (nums[i] > nums[i + 1]) swap(nums, i, i + 1);
            } else {
                if (nums[i] < nums[i + 1]) swap(nums, i, i + 1);
            }
            less = !less;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }
}
