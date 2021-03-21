public class Solution242 {
    public boolean isAnagram(String s, String t) {
        int[] charMap = new int[26];
        for (char c : s.toCharArray()) {
            charMap[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            charMap[c - 'a']--;
        }
        for (int i : charMap) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
