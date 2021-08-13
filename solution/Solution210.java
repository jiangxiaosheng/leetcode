import java.util.*;

public class Solution210 {
    // dfs version
//
//    List<List<Integer>> edges;
//    boolean valid = true;
//    int[] status;
//    int[] res;
//    int idx;
//
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        edges = new ArrayList<>();
//        res = new int[numCourses];
//        status = new int[numCourses];
//        idx = numCourses - 1;
//        for (int i = 0; i < numCourses; i++) edges.add(new ArrayList<>());
//        for (int[] pre : prerequisites) {
//            edges.get(pre[1]).add(pre[0]);
//        }
//        for (int i = 0; i < numCourses && valid; i++) {
//            if (status[i] == 0)
//                dfs(i);
//        }
//        if (!valid) return new int[0];
//        return res;
//    }
//
//    private void dfs(int n) {
//        status[n] = 1;
//        for (int e : edges.get(n)) {
//            if (status[e] == 0) {
//                dfs(e);
//                if (!valid) return;
//            } else if (status[e] == 1) {
//                valid = false;
//                return;
//            }
//        }
//        res[idx--] = n;
//        status[n] = 2;
//    }

    // bfs version

    List<List<Integer>> edges;
    int[] inDeg;
    int[] res;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        inDeg = new int[numCourses];
        res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            edges.get(pre[1]).add(pre[0]);
            inDeg[pre[0]]++;
        }
        System.out.println(Arrays.toString(inDeg));
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] == 0) queue.offer(i);
        }
        int idx = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int e : edges.get(curr)) {
                --inDeg[e];
                if (inDeg[e] == 0) queue.offer(e);
            }
            res[idx++] = curr;
        }
        if (idx != numCourses) return new int[0];
        return res;
    }
}
