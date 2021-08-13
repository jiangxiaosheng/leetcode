import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution1249 {

    static class Status {
        char c;
        int idx;

        Status(char c, int i) {
            this.c = c;
            idx = i;
        }

        @Override
        public String toString() {
            return c + " " + idx;
        }
    }

    public String minRemoveToMakeValid(String s) {
        Stack<Status> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                if (!stack.isEmpty() && stack.peek().c == '(' && c == ')')
                    stack.pop();
                else
                    stack.push(new Status(c, i));
            }
        }
        Set<Integer> set = new HashSet<>();
        while (!stack.empty()) {
            set.add(stack.pop().idx);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
