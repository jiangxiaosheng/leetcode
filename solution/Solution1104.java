import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution1104 {
    public List<Integer> pathInZigZagTree(int label) {
        Stack<Integer> stack = new Stack<>();
        int ori = reverse(label);
        while (ori != 0) {
            stack.push(ori);
            ori /= 2;
        }
        List<Integer> res = new ArrayList<>();
        while (!stack.empty()) {
            res.add(reverse(stack.pop()));
        }
        return res;
    }

    private int reverse(int x) {
        int line = (int) (Math.log(x) / Math.log(2));
        if (line % 2 != 0) {
            int diff = x - (1 << line);
            x = (1 << (line + 1)) - 1 - diff;
        }
        return x;
    }
}
