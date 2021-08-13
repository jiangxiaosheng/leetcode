public class Solution33 {
    // 4 5 6 7 0 1 2
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int m = (l + r) >> 1;
        while (l <= r) {
            if (nums[m] == target) {
                return m;
            }
            if (nums[r] > nums[l]) {
                if (nums[m] < target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if (nums[m] >= nums[l]) {
                    if (target < nums[l] || target > nums[m]) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                } else {
                    if (target >= nums[l] || target < nums[m]) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
            }
            m = (l + r) >> 1;
        }
        return -1;
    }
}
