import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>();
        List<List<String>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.get(0).add("");
        StringBuilder sb;
        for (int i = 1; i <= n; i++) {
            list.add(new ArrayList<>());
            for (int j = 0; j <= i - 1; j++) {
                List<String> rightPart = list.get(i - 1 - j);
                List<String> leftPart = list.get(j);
                for (String l : leftPart) {
                    for (String r : rightPart) {
                        sb = new StringBuilder();
                        sb.append("(").append(l).append(")").append(r);
                        list.get(i).add(sb.toString());
                    }
                }
            }
        }
        return list.get(n);
    }
}
