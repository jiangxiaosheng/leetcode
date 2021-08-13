public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int index = 0;
        while (has(strs, index))
            index++;
        return strs[0].substring(0, index);
    }

    boolean has(String[] strs, int i) {
        for (String s: strs) {
            if (s.length() <= i || s.charAt(i) != strs[0].charAt(i))
                return false;
        }
        return true;
    }
}
