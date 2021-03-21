public class Solution944 {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        for (int col = 0; col < strs[0].length(); col++) {
            if (!isLexicographical(strs, col))
                count++;
        }
        return count;
    }

    private boolean isLexicographical(String[] strs, int col) {
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].charAt(col) < strs[i - 1].charAt(col))
                return false;
        }
        return true;
    }
}
