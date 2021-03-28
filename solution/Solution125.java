public class Solution125 {
    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; j >= i; i++, j--) {
            while (i < s.length() && !isValidChar(s.charAt(i))) i++;
            while (j >= 0 && !isValidChar(s.charAt(j))) j--;
            if (i > j) return true;
            if (lowerCase(s.charAt(i)) != lowerCase(s.charAt(j))) return false;
        }
        return true;
    }

    private boolean isValidChar(char c) {
        return c >= 'a' && c <= 'z' || c >= '0' && c <= '9' || c >= 'A' && c <= 'Z';
    }

    private char lowerCase(char c) {
        if (c >= 'A' && c <= 'Z') return (char) (c + 32);
        return c;
    }
}
