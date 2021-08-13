import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution254 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, new ArrayDeque<>(), res);
        return res;
    }

    private void dfs(int n, Deque<Integer> path, List<List<Integer>> res) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                path.addLast(i);
//                path.addLast(n / i);
                dfs(n / i, path, res);
                res.add(new ArrayList<>(path));
                path.removeLast();
            }
        }
    }
}
