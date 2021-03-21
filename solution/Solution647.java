public class Solution647 {
    // center expanding version
    int cnt = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            expand(s, i);
        }
        return cnt;
    }

    private void expand(String s, int center) {
        for (int i = 0; center - i >= 0 && center + i < s.length(); i++) {
            if (s.charAt(center - i) == s.charAt(center + i))
                cnt++;
            else
                break;
        }
        if (center + 1 < s.length() && s.charAt(center + 1) == s.charAt(center)) {
            for (int i = 0; center - i >= 0 && center + 1 + i < s.length(); i++) {
                if (s.charAt(center - i) == s.charAt(center + 1 + i))
                    cnt++;
                else
                    break;
            }
        }
    }

    // DP version
//    public int countSubstrings(String s) {
//        int n = s.length();
//        boolean[][] dp = new boolean[n][n];
//        int cnt = 0;
//        for (int i = n - 1; i >= 0; i--) {
//            for (int j = n - 1; j >= i; j--) {
//                if (i == j) {
//                    dp[i][j] = true;
//                    cnt++;
//                } else {
//                    if (s.charAt(i) == s.charAt(j)) {
//                        if (j == i + 1) {
//                            dp[i][j] = true;
//                            cnt++;
//                        } else {
//                            dp[i][j] = dp[i + 1][j - 1];
//                            if (dp[i][j])
//                                cnt++;
//                        }
//                    }
//                }
//            }
//        }
//        return cnt;
//    }
}
