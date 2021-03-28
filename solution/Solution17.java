import java.util.*;

public class Solution17 {
    private Map<Character, List<Character>> digits = new HashMap<>();

    {
        digits.put('2', Arrays.asList('a', 'b', 'c'));
        digits.put('3', Arrays.asList('d', 'e', 'f'));
        digits.put('4', Arrays.asList('g', 'h', 'i'));
        digits.put('5', Arrays.asList('j', 'k', 'l'));
        digits.put('6', Arrays.asList('m', 'n', 'o'));
        digits.put('7', Arrays.asList('p', 'q', 'r', 's'));
        digits.put('8', Arrays.asList('t', 'u', 'v'));
        digits.put('9', Arrays.asList('w', 'x', 'y', 'z'));

    }

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        backtrack(digits, 0, res, new StringBuilder(""));
        return res;
    }

    private void backtrack(String digits, int cur, List<String> res, StringBuilder s) {
        if (s.length() == digits.length()) {
            res.add(s.toString());
            return;
        }
        List<Character> l = this.digits.get(digits.charAt(cur));
        for (Character character : l) {
            s.append(character);
            backtrack(digits, cur + 1, res, s);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
