import java.util.*;

public class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[candidates.length];
        dfs(candidates, visited, new ArrayDeque<>(), res, target, 0);
        return res;
    }

    private void dfs(int[] candidates, boolean[] visited, Deque<Integer> path, List<List<Integer>> res, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        int last = -1;
        for (int i = start; i < candidates.length; i++) {
            if (visited[i]) continue;
            if (target - candidates[i] < 0) break;
            if (candidates[i] == last) continue;
            last = candidates[i];
            visited[i] = true;
            path.addLast(candidates[i]);
            dfs(candidates, visited, path, res, target - candidates[i], i);
            path.removeLast();
            visited[i] = false;
        }
    }
}
