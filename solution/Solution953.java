import java.util.HashMap;
import java.util.Map;

public class Solution953 {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> dic = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            dic.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            if (compare(words[i - 1], words[i], dic))
                return false;
        }
        return true;
    }

    private boolean compare(String w1, String w2, Map<Character, Integer> dic) {
        int p1 = 0, p2 = 0;
        while (p1 < w1.length() && p2 < w2.length()) {
            if (dic.get(w1.charAt(p1)) > dic.get(w2.charAt(p2)))
                return true;
            else if (dic.get(w1.charAt(p1)) < dic.get(w2.charAt(p2)))
                return false;
            p1++;
            p2++;
        }
        return w1.length() > w2.length();
    }

}
