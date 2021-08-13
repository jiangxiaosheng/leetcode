import java.util.Stack;

public class Solution1209 {
    // "deeedbbcccbdaa", 3
//    public String removeDuplicates(String s, int k) {
//        int[] counter = new int[s.length()];
//        StringBuilder sb = new StringBuilder(s);
//        for (int i = 0; i < sb.length(); i++) {
//            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
//                counter[i] = 1;
//            } else {
//                counter[i] = counter[i - 1] + 1;
//                if (counter[i] == k) {
//                    sb.delete(i - k + 1, i + 1);
//                    i = i - k;
//                }
//            }
//        }
//        return sb.toString();
//    }

    public String removeDuplicates(String s, int k) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                stack.push(1);
            } else {
                int t = stack.pop();
                if (t == 2) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                }
                stack.push(t + 1);
            }
        }
        return sb.toString();
    }
}
