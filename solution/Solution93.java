import java.util.ArrayList;
import java.util.List;

public class Solution93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, res, new StringBuilder(), 0);
        return res;
    }

    // 25525511135
    private void dfs(String s, List<String> res, StringBuilder path, int cnt) {
        if (cnt == 4) {
            if (s.equals(""))
                res.add(path.substring(0, path.length() - 1));
            return;
        }

        if (s.equals(""))
            return;

        path.append(s.charAt(0)).append('.');
        dfs(s.substring(1), res, path, cnt + 1);
        path.delete(path.length() - 2, path.length());

        if (s.charAt(0) != '0') {
            if (s.length() > 1) {
                path.append(s.charAt(0)).append(s.charAt(1)).append('.');
                dfs(s.substring(2), res, path, cnt + 1);
                path.delete(path.length() - 3, path.length());
            }

            if (s.length() > 2) {
                if (s.charAt(0) == '1' || (s.charAt(0) == '2' && s.charAt(1) < '5') ||
                        (s.charAt(0) == '2' && s.charAt(1) == '5' && s.charAt(2) <= '5')) {
                    path.append(s.charAt(0)).append(s.charAt(1)).append(s.charAt(2)).append('.');
                    dfs(s.substring(3), res, path, cnt + 1);
                    path.delete(path.length() - 4, path.length());
                }
            }
        }
    }
}
