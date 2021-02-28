import java.util.Arrays;
import java.util.Comparator;

public class Solution452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length < 2) return points.length;
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int count = 0;
        int[] start = points[0];
        for (int[] point : points) {
            if (point[0] > start[1]) {
                start = point;
                count++;
            }
        }
        return count + 1;
    }
}
