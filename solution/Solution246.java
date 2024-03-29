public class Solution246 {
    public boolean isStrobogrammatic(String num) {
        for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
            if (!symmetric(num.charAt(i), num.charAt(j))) return false;
        }
        return true;
    }

    private boolean symmetric(char a, char b) {
        return (a == '1' && b == '1') || (a == '8' && b == '8') || (a == '6' && b == '9') || (a == '9' && b == '6')
                || (a == '0' && b == '0');
    }
}
