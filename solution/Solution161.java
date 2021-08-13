public class Solution161 {
    // "a", "ac"
    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t) || Math.abs(s.length() - t.length()) > 1) return false;
        boolean flag = false;
        if (s.length() == t.length()) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (flag) return false;
                    flag = true;
                }
            }
        } else if (s.length() > t.length()) {
            int ps = 0, pt = 0;
            while (ps < s.length()) {
                if (pt == t.length()) return true;
                if (s.charAt(ps) != t.charAt(pt)) {
                    if (flag) return false;
                    flag = true;
                    ps++;
                    continue;
                }
                ps++;
                pt++;
            }
        } else {
            int ps = 0, pt = 0;
            while (pt < t.length()) {
                if (ps == s.length()) return true;
                if (s.charAt(ps) != t.charAt(pt)) {
                    if (flag) return false;
                    flag = true;
                    pt++;
                    continue;
                }
                ps++;
                pt++;
            }
        }
        return flag;
    }
}
