public class Solution5 {

    int maxLength = -1;
    String longestStr = "";

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, 0);
            helper(s, i, 1);
        }
        return longestStr;
    }

    private void helper(String s, int central, int offset) {
        int length;
        for (int i = 0; central - i >= 0 && central + offset + i < s.length(); i++) {
            if (s.charAt(central - i) != s.charAt(central + offset + i))
                return;
            length = 2 * i + 1 + offset;
            if (length > maxLength) {
                maxLength = length;
                longestStr = s.substring(central - i, central + offset + i + 1);
            }
        }
    }
}
