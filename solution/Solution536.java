import java.util.Stack;

public class Solution536 {
    public TreeNode str2tree(String s) {
        if (s.equals("")) return null;
        int idx = 0;
        while (idx < s.length() && s.charAt(idx) != '(') idx++;
        int val = Integer.parseInt(s.substring(0, idx));
        TreeNode root = new TreeNode(val);
        if (idx == s.length()) return root;
        Stack<Character> stack = new Stack<>();
        int t = idx;
        while (idx < s.length()) {
            if (s.charAt(idx) == '(') {
                stack.push('(');
            } else if (s.charAt(idx) == ')') {
                stack.pop();
                if (stack.empty()) break;
            }
            idx++;
        }
        String ls = s.substring(t + 1, idx);
        root.left = str2tree(ls);
        idx++;
        if (idx == s.length()) return root;
        t = idx;
        stack.clear();
        while (idx < s.length()) {
            if (s.charAt(idx) == '(') {
                stack.push('(');
            } else if (s.charAt(idx) == ')') {
                stack.pop();
                if (stack.empty()) break;
            }
            idx++;
        }
        String rs = s.substring(t + 1, idx);
        root.right = str2tree(rs);
        return root;
    }
}
