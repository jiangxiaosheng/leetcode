import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution90 {
    // 1, 2, 2
    // 4, 4, 1, 4
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, res, 0, new ArrayList<>());
        return res;
    }

    // TODO
    private void backtrack(int[] nums, List<List<Integer>> res, int idx, List<Integer> curr) {
        res.add(new ArrayList<>(curr));
        if (idx == nums.length) return;
        int prev = nums[idx] + 1;
        for (int i = idx; i < nums.length; i++) {
            if (nums[i] == prev) continue;
            prev = nums[i];
            curr.add(nums[i]);
            backtrack(nums, res, i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
