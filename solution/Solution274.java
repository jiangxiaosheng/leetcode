import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Solution274 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] counter = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                counter[n]++;
            } else {
                counter[citations[i]]++;
            }
        }
        int cnt = 0;
        for (int i = n; i >= 0; i--) {
            cnt += counter[i];
            if (i <= cnt) {
                return i;
            }
        }
        return -1;
    }
}
