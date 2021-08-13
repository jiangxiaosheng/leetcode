import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class Solution1337 {

    static class Row implements Comparable<Row> {
        int val;
        int idx;

        Row(int v, int i) {
            val = v;
            idx = i;
        }

        @Override
        public int compareTo(Row o) {
            return this.val - o.val;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        Queue<Row> pq = new PriorityQueue<>();
        int factor = 1000;
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            int power = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0)
                    break;
                power++;
            }
            pq.offer(new Row(power * factor + i, i));
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().idx;
        }
        return res;
    }
}
