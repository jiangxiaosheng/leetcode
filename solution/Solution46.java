import java.util.ArrayList;
import java.util.List;

public class Solution46 {

    private boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        visited = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            curr.add(nums[i]);
            visited[i] = true;
            backtrack(nums, curr, res);
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }
}
