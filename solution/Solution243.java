import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution243 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int i1 = -1, i2 = -1;
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1))
                i1 = i;
            if (wordsDict[i].equals(word2))
                i2 = i;
            if (i1 != -1 && i2 != -1)
                shortest = Math.min(Math.abs(i1 - i2), shortest);
        }
        return shortest;
    }
}
