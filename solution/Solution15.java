import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int k = nums.length - 1;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                while (k > j && nums[i] + nums[j] + nums[k] > 0) k--;
                if (k <= j) break;
                if (nums[i] + nums[j] + nums[k] == 0)
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
            }
        }
        return res;
    }
}
