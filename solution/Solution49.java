import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> dic = new HashMap<>();
        for (String s : strs) {
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                key.append((char)('a' + i)).append(freq[i]);
            }
            if (!dic.containsKey(key.toString())) {
                dic.put(key.toString(), new ArrayList<>());
            }
            dic.get(key.toString()).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> i : dic.values()) {
            res.add(new ArrayList<>(i));
        }
        return res;
    }
}
