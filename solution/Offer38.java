import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer38 {
    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        char[] sorted = s.toCharArray();
        Arrays.sort(sorted);
        dfs(sorted, res, new StringBuilder(), new boolean[s.length()]);
        return res.toArray(new String[]{});
    }

    void dfs(char[] chs, List<String> res, StringBuilder path, boolean[] visited) {
        if (path.length() == chs.length) {
            res.add(path.toString());
        }
        char last = 0;

        for (int i = 0; i < chs.length; i++) {
            if (visited[i]) continue;
            if (chs[i] == last) continue;
            last = chs[i];
            path.append(chs[i]);
            visited[i] = true;
            dfs(chs, res, path, visited);
            path.deleteCharAt(path.length() - 1);
            visited[i] = false;
        }
    }
}
