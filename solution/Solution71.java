import java.util.*;

public class Solution71 {

    // /a/./b/../../c/
    public String simplifyPath(String path) {
        StringBuilder res = new StringBuilder();
        String[] groups = path.split("/");
        Deque<String> queue = new ArrayDeque<>();
        for (String g : groups) {
            if (g.equals("") || g.equals(".")) continue;
//            System.out.println(g);
            if (g.equals("..")) {
                if (!queue.isEmpty()) {
                    queue.removeLast();
                }
            } else {
                queue.addLast(g);
            }
        }
        for (String s : queue) {
            res.append('/').append(s);
        }
        if (res.length() == 0)
            res.append('/');
        return res.toString();
    }
}
