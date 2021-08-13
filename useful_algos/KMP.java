import java.util.*;

public class KMP {
    // "abacaba"
    static private int[] computeBorderArray(String pattern) {
        int[] border = new int[pattern.length() + 1];
        border[0] = -1;
        int pos = 1, cnd = 0;
        while (pos < pattern.length()) {
            if (pattern.charAt(pos) == pattern.charAt(cnd)) {
                border[pos] = border[cnd];
            } else {
                border[pos] = cnd;
                while (cnd >= 0 && pattern.charAt(pos) != pattern.charAt(cnd))
                    cnd = border[cnd];
            }
            pos++;
            cnd++;
        }
        border[pos] = cnd;
        return border;
    }

    static public List<Integer> KMPSearch(String text, String pattern) {
        List<Integer> positions = new ArrayList<>();
        int j = 0, k = 0;
        int[] border = computeBorderArray(pattern);
        while (j < text.length()) {
            if (pattern.charAt(k) == text.charAt(j)) {
                j++;
                k++;
                if (k == pattern.length()) {
                    positions.add(j - k);
                    k = border[k];
                }
            } else {
                k = border[k];
                if (k < 0) {
                    j++;
                    k++;
                }
            }
        }
        return positions;
    }

    static int indexOfLongestTandemRepeat(String text, String pattern) {
        List<Integer> positions = KMPSearch(text, pattern);
        Map<Integer, Integer> m = new HashMap<>();
        int firstIndex = positions.get(0), prev = firstIndex, cnt = 1;
        for (int i = 1; i < positions.size(); i++) {
            int pos = positions.get(i);
            if (pos - prev == pattern.length()) {
                cnt++;
            } else {
                if (!m.containsKey(cnt))
                    m.put(cnt, firstIndex);
                firstIndex = pos;
                cnt = 1;
            }
            prev = pos;
        }
        if (!m.containsKey(cnt))
            m.put(cnt, firstIndex);
        return m.get(Collections.max(m.keySet()));
    }

    public static void main(String[] args) {
        System.out.println(indexOfLongestTandemRepeat("abcabcababcabcababcababcabjjjjjababcababcab", "abcab"));
    }
}
