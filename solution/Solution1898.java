import java.util.ArrayList;
import java.util.List;

public class Solution1898 {
    public int maximumRemovals(String s, String p, int[] removable) {
        int l = 0, r = removable.length - 1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (check(s, p, removable, m)) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r + 1;
    }

    public boolean check(String s, String p, int[] removable, int k) {
        boolean[] remove = new boolean[s.length()];
        for (int i = 0; i <= k; i++) {
            remove[removable[i]] = true;
        }
        int i = 0, j = 0;
        for (; i < s.length(); i++) {
            if (remove[i]) continue;
            if (s.charAt(i) == p.charAt(j))
                j++;
            if (j == p.length()) return true;
        }
        return false;
    }
}
