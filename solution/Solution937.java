import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution937 {
    public String[] reorderLogFiles(String[] logs) {
        List<String> alphas = new ArrayList<>(), numbers = new ArrayList<>();
        for (String s : logs) {
            char c = s.charAt(s.indexOf(' ') + 1);
            if (c >= '0' && c <= '9') {
                numbers.add(s);
            } else {
                alphas.add(s);
            }
        }
        alphas.sort((o1, o2) -> {
            String content1 = o1.substring(o1.indexOf(' ') + 1), content2 = o2.substring(o2.indexOf(' ') + 1);
            String id1 = o1.substring(0, o1.indexOf(' ') + 1), id2 = o2.substring(0, o2.indexOf(' ') + 1);
            if (!content1.equals(content2)) return content1.compareTo(content2);
            return id1.compareTo(id2);
        });
        alphas.addAll(numbers);
        return alphas.toArray(new String[]{});
    }
}
