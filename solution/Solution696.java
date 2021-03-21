import java.util.Arrays;

public class Solution696 {
    // "00110011"
    public int countBinarySubstrings(String s) {
        int[] groups = new int[s.length()];
        int idx = 0;
        groups[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                groups[idx]++;
            } else {
                groups[++idx] = 1;
            }
        }
        int count = 0;
        for (int i = 1; i <= idx; i++) {
            count += Math.min(groups[i], groups[i - 1]);
        }
        return count;
    }
}
