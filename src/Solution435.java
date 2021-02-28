import java.util.Arrays;
import java.util.Comparator;

public class Solution435 {
    // [[1,2],[2,3],[3,4],[1,3]]
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 1) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int count = 1;
        int[] start = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= start[1]) {
                count++;
                start = intervals[i];
            }
        }
        return intervals.length - count;
    }
}
