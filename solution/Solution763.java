import java.util.ArrayList;
import java.util.List;

public class Solution763 {
    // "ababcbacadefegdehijhklij"
    public List<Integer> partitionLabels(String S) {
         int[] last = new int[26];
         for (int i = 0; i < S.length(); i++) {
             last[S.charAt(i) - 'a'] = i;
         }
         List<Integer> res = new ArrayList<>();
         int curr = 0;
         while (curr < S.length()) {
             int start = curr, end = last[S.charAt(start) - 'a'], idx = start;
             while (idx != end) {
                 idx++;
                 end = Math.max(last[S.charAt(idx) - 'a'], end);
             }
             res.add(end - start + 1);
             curr = end + 1;
         }
         return res;
    }
}
