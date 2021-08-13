import java.util.Stack;

public class Solution331 {
    public boolean isValidSerialization(String preorder) {
        if (preorder.equals("#")) return true;
        String[] words = preorder.split(",");
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < words.length; i++) {
            String token = words[i];
            if (token.charAt(0) <= '9' && token.charAt(0) >= '0')
                stack.push(new int[]{Integer.parseInt(token), 2});
            else if (token.equals("#")) {
                if (stack.empty()) return false;
                int[] pair = stack.peek();
                pair[1] -= 1;
                while (pair[1] == 0) {
                    stack.pop();
                    if (stack.empty()) return i == words.length - 1;
                    pair = stack.peek();
                    pair[1] -= 1;
                }
            }
        }
        return stack.empty();
    }
}
