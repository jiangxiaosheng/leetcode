import java.util.*;

public class Solution1239 {
    private int maxLength = 0;
    private final boolean[] occ = new boolean[26];

    public int maxLength(List<String> arr) {
        Set<String> set = new HashSet<>();
        for (String s : arr) {
            if (noDuplicate(s))
                set.add(s);
        }
        Arrays.fill(occ, false);
        boolean[] visited = new boolean[set.size()];
        dfs_backtrack(new StringBuilder(), visited, new ArrayList<>(set), 0);
        return maxLength;
    }

    // ["un","iq","ue"]
    private void dfs_backtrack(StringBuilder path, boolean[] visited, List<String> arr, int start) {
        for (int i = start; i < arr.size(); i++) {
            String s = arr.get(i);
            if (visited[i]) continue;
            if (!hasOverlap(s)) {
                path.append(s);
                visited[i] = true;
                maxLength = Math.max(maxLength, path.length());
                for (char c : s.toCharArray()) {
                    occ[c - 'a'] = true;
                }
                dfs_backtrack(path, visited, arr, i + 1);
                path.delete(path.length() - s.length(), path.length());
                for (char c : s.toCharArray()) {
                    occ[c - 'a'] = false;
                }
                visited[i] = false;
            }
        }
    }

    private boolean hasOverlap(String s) {
        for (char c : s.toCharArray()) {
            if (occ[c - 'a'])
                return true;
        }
        return false;
    }

    private boolean noDuplicate(String s) {
        Arrays.fill(occ, false);
        for (char c : s.toCharArray()) {
            if (occ[c - 'a'])
                return false;
            occ[c - 'a'] = true;
        }
        return true;
    }
}