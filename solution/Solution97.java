public class Solution97 {
    // s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if (n1 + n2 != n3) return false;
        boolean[] dp = new boolean[n2 + 1];
        dp[0] = true;
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0 && j > 0) {
                    if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
                        dp[j] = dp[j - 1];
                    } else {
                        dp[j] = false;
                    }
                    continue;
                }
                if (j == 0 && i > 0) {
                    if (s1.charAt(i - 1) != s3.charAt(i - 1)) {
                        dp[0] = false;
                    }
                    continue;
                }
                char c = s3.charAt(i + j - 1);
                dp[j] = (dp[j] && s1.charAt(i - 1) == c) || (dp[j - 1] && s2.charAt(j - 1) == c);
            }
        }
        return dp[n2];
    }
}
