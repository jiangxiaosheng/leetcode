import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1010 {
    // [30,20,150,100,40]
    public int numPairsDivisibleBy60(int[] time) {
        int cnt = 0;
        int[] times = new int[60];
        for (int t : time) {
            times[t % 60]++;
        }
        cnt += times[30] * (times[30] - 1) / 2;
        cnt += times[0] * (times[0] - 1) / 2;
        for (int i = 1; i < 30; i++) {
            cnt += times[i] * times[60 - i];
        }
        return cnt;
    }
}
