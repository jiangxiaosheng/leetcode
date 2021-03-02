public class Solution665 {
    public boolean checkPossibility(int[] nums) {
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (count > 0) {
                    if (i - 1 == 0 || (nums[i - 2] <= nums[i])) {
                        nums[i - 1] = nums[i];
                    } else {
                        nums[i] = nums[i - 1];
                    }
                    count--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
