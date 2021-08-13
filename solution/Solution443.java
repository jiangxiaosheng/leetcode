import java.util.Arrays;

public class Solution443 {
    // ["a","a","b","b","c","c","c"]
    // ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
    public int compress(char[] chars) {
        int ans = 0, idx = 0, i;
        char prev;
        char[] t;
        while (idx < chars.length) {
            prev = chars[idx];
            for (i = idx; i < chars.length && chars[i] == prev; i++) ;
            chars[ans] = prev;
            ans += 1;
            if (i - idx != 1) {
                int cnt = i - idx;
                t = ("" + cnt).toCharArray();
                System.arraycopy(t, 0, chars, ans, t.length);
                ans += t.length;
            }
            idx = i;
        }
        System.out.println(Arrays.toString(chars));
        return ans;
    }
}
