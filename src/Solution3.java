import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    // sliding window
    // "abcabcbb"
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, maxLength = 0;
        while (right < s.length() && left <= right) {
            char currChar = s.charAt(right);
            if (!set.contains(currChar)) {
                right++;
                set.add(currChar);
                if (right - left > maxLength)
                    maxLength = right - left;
            } else {
                while (s.charAt(left) != currChar) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
                right++;
            }
        }
        return maxLength;
    }
}
