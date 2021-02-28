import java.util.Stack;

public class Solution1598 {
    public int minOperations(String[] logs) {
        Stack<Object> ops = new Stack<>();
        for (String log : logs) {
            if (log.equals("../")) {
                if (!ops.empty())
                    ops.pop();
            } else if (log.equals("./")) {
                continue;
            } else {
                ops.push(null);
            }
        }
        return ops.size();
    }
}
