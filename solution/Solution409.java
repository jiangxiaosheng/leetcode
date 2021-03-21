import java.util.HashMap;
import java.util.Map;

public class Solution409 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        boolean hasOdd = false;
        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if (val % 2 == 0) {
                count += val;
            } else {
                count += val - 1;
                hasOdd = true;
            }
        }
        return hasOdd ? count + 1 : count;
    }
}
