import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution253 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int cnt = 0;
        for (int[] interval : intervals) {
            if (pq.isEmpty()) {
                pq.offer(interval);
                cnt++;
                continue;
            }
            if (pq.peek()[1] <= interval[0]) {
                pq.poll();
            } else {
                cnt++;
            }
            pq.offer(interval);
        }
        return cnt;
    }
}
