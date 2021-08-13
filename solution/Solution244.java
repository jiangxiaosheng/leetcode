import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution244 {
    static class WordDistance {

        Map<String, List<Integer>> map = new HashMap<>();

        public WordDistance(String[] wordsDict) {
            for (int i = 0; i < wordsDict.length; i++) {
                List<Integer> loc = map.getOrDefault(wordsDict[i], new ArrayList<>());
                loc.add(i);
                map.put(wordsDict[i], loc);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> loc1 = map.get(word1), loc2 = map.get(word2);
            int res = Integer.MAX_VALUE;
            int p1 = 0, p2 = 0, idx1, idx2;
            while (p1 < loc1.size() && p2 < loc2.size()) {
                idx1 = loc1.get(p1);
                idx2 = loc2.get(p2);
                res = Math.min(res, Math.abs(idx1 - idx2));
                if (idx1 > idx2) p2++;
                else p1++;
            }
            return res;
        }
    }
}
