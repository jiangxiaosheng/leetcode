public class Solution680 {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (r > l) {
            if (s.charAt(l) == s.charAt(r)) {
                r--;
                l++;
            } else {
                return helper(s, l + 1, r) || helper(s, l, r - 1);
            }
        }
        return true;
    }

    private boolean helper(String s, int l, int r) {
        int i = l, j = r;
        while (j > i) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
