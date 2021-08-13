import java.util.*;

public class Solution159 {
    // "eceba"
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0, right = 0, max = -1;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            if (map.size() < 3) map.put(s.charAt(right), right++);
            if (map.size() == 3) {
                int idxToBeDeleted = Collections.min(map.values());
                map.remove(s.charAt(idxToBeDeleted));
                left = idxToBeDeleted + 1;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}
