public class Solution704 {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid;
        while (hi >= lo) {
            mid = (lo + hi) >> 1;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        return -1;
    }
}
