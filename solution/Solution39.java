import java.util.*;

public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        int begin = 0;
        dfs_backtrack(res, new ArrayDeque<>(), candidates, target, begin);
        return res;
    }

    private void dfs_backtrack(List<List<Integer>> res, Deque<Integer> l, int[] candidates, int target, int begin) {
        if (target == 0) {
            res.add(new ArrayList<>(l));
        }
        for (int i = begin; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (target < candidate) break; // prune
            l.addLast(candidate);
            dfs_backtrack(res, l, candidates, target - candidate, i);
            l.removeLast();
        }
    }
}
