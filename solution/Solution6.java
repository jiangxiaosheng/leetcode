import java.util.ArrayList;
import java.util.List;

public class Solution6 {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        int idx = 0, dir = 1, tag = 1;
        List<List<Character>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++)
            lists.add(new ArrayList<>());
        while (idx < s.length()) {
            lists.get(tag - 1).add(s.charAt(idx));
            if (dir == 1) {
                if (tag < numRows) {
                    tag++;
                } else {
                    dir = -1;
                    tag--;
                }
            } else {
                if (tag == 1) {
                    dir = 1;
                    tag++;
                } else {
                    tag--;
                }
            }
            idx++;
        }
        StringBuilder sb = new StringBuilder();
        for (List<Character> row : lists) {
            for (char c : row) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
