import java.util.*;

public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = nums.length - 1;
                for (int k = j + 1; k < nums.length - 1; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue;
                    while (l > k && nums[i] + nums[j] + nums[k] + nums[l] > target) l--;
                    if (l <= k) break;
                    if (nums[i] + nums[j] + nums[k] + nums[l] == target)
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                }
            }
        }
        return res;
    }
}
