public class Solution1897 {
    public boolean makeEqual(String[] words) {
        int[] freq = new int[26];
        for (String w : words) {
            for (char c : w.toCharArray()) {
                freq[c - 'a']++;
            }
        }
        int numWords = words.length;
        for (int f : freq) {
            if (f % numWords != 0)
                return false;
        }
        return true;
    }
}
