import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution611 {
    // [2, 2, 3, 4]
//    public int triangleNumber(int[] nums) {
//        Arrays.sort(nums);
//        int cnt = 0;
//        int j, k;
//        for (int i = 0; i < nums.length - 2; i++) {
//            for (j = i + 1; j < nums.length - 1; j++) {
//                k = binFind(nums, j + 1, nums.length - 1, nums[i] + nums[j]);
//                cnt += k - j;
//            }
//        }
//        return cnt;
//    }
//
//    private int binFind(int[] nums, int left, int right, int sum) {
//        int mid;
//        while (left <= right) {
//            mid = (left + right) >> 1;
//            if (nums[mid] < sum) left = mid + 1;
//            else right = mid - 1;
//        }
//        return left - 1;
//    }

    // two-pointer version
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int cnt = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) continue;
            int k = i + 1;
            for (int j = i + 1; j < nums.length - 1; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k]) k++;
                cnt += k - j - 1;
            }
        }
        return cnt;
    }
}
