import java.util.*;

public class Solution310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        List<List<Integer>> neighbors = new ArrayList<>();
        int[] inDeg = new int[n];
        for (int i = 0; i < n; i++) neighbors.add(new ArrayList<>());
        for (int[] edge : edges) {
            inDeg[edge[0]]++;
            inDeg[edge[1]]++;
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 1) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            res = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                res.add(cur);
                for (int e : neighbors.get(cur)) {
                    --inDeg[e];
                    if (inDeg[e] == 1) queue.offer(e);
                }
            }
        }
        return res;
    }
}
