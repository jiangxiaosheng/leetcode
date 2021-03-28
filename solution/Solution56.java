import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution56 {
    // [[1,3],[2,6],[8,10],[15,18]]
    // [[1, 10], [2, 3], [4, 5], [6, 7], [8, 9]]
    // [[1,4],[4,5]]
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, ((o1, o2) -> o1[0] - o2[0]));
        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                if (intervals[i][1] > end)
                    end = intervals[i][1];
            } else {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[][]{});
    }
}
