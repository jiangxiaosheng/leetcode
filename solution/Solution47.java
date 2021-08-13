import java.util.*;

public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(res, new ArrayDeque<>(), nums, visited);
        return res;
    }

    // 1 1 2
    private void backtrack(List<List<Integer>> res, Deque<Integer> path, int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }
        int cur = -20;
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            int n = nums[i];
            if (n == cur) continue;
            cur = n;
            visited[i] = true;
            path.addLast(n);
            backtrack(res, path, nums, visited);
            path.removeLast();
            visited[i] = false;
        }
    }
}
