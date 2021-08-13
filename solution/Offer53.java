public class Offer53 {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, cnt = 0, mid = (lo + hi) >> 1;
        boolean found = false;
        while (hi >= lo) {
            if (nums[mid] == target) {
                found = true;
                cnt = 1;
                break;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
            mid = (lo + hi) >> 1;
        }
        if (found) {
            for (int i = mid - 1; i >= 0; i--) {
                if (nums[i] != target)
                    break;
                cnt++;
            }
            for (int i = mid + 1; i < nums.length; i++) {
                if (nums[i] != target)
                    break;
                cnt++;
            }
        }
        return cnt;
    }
}
