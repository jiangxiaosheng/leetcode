import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution394 {
//    public String decodeString(String s) {
//        groups(s);
//        return "";
//    }

    // 3[a2[c]]
    // abc3[cd]xyz
//    private StringBuilder innerDecode(String s) {
//        StringBuilder res = new StringBuilder();
//        int idx = s.indexOf('[');
//        while (idx != 0) {
//            int times = s.charAt(idx - 1) - '0';
//            res.append(s.substring(0, idx - 1));
//            for (int i = 0; i < times - 1; i++)
//                res.append(innerDecode(s.substring(idx + 1, s.indexOf(']')1)));
//            idx = s.indexOf('[');
//        }
////        for (int i = 0; i < times - 1; i++)
////            res.append(res);
//        return res;
//    }
//
//    // abc3[cd]xyz
//    private String[] groups(String s) {
//        List<String> res = new ArrayList<>();
//        Stack<Character> stack = new Stack<>();
//        StringBuilder sb = new StringBuilder();
//        int p = 0;
//        char c;
//        boolean flag = false;
//        while (p < s.length()) {
//            c = s.charAt(p);
//            sb.append(c);
//            if (c == '[') {
//                stack.push(c);
//                flag = true;
//            }
//            else if (c == ']')
//                stack.pop();
//            if (stack.empty() && flag) {
//                res.add(sb.toString());
//                sb.delete(0, sb.length());
//                flag = false;
//            }
//            p++;
//        }
//        res.add(sb.toString());
//        System.out.println(res);
//        return res.toArray(new String[]{});
//    }
}
