import java.util.ArrayList;
import java.util.List;

public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        boolean overlap = false;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[1] >= newInterval[0] && interval[0] <= newInterval[1]) {
                overlap = true;
                int[] t = new int[]{Math.min(interval[0], newInterval[0]), Math.max(interval[1], newInterval[1])};
                while (t[1] >= intervals[i + 1][0] && t[0] <= intervals[i + 1][1]) {
                    i++;
                    t[1] = Math.max(t[1], intervals[i + 1][1]);
                }
                res.add(t);
            } else {
                res.add(interval);
            }
        }
        if (!overlap) {
            int i;
            for (i = 0; i < intervals.length; i++) {
                if (intervals[i][0] > newInterval[1])
                    break;
            }

            res.add(i, newInterval);
        }
        return res.toArray(new int[][]{});
    }
}
