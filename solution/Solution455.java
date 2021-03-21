import java.util.Arrays;

public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            while (s[j] < g[i]) {
                j++;
                if (j == s.length)
                    return i;
            }
            i++;
            j++;
        }
        return i;
    }
}
