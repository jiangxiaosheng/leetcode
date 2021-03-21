import java.util.Stack;

public class Solution739 {
    // T = [73, 74, 75, 71, 69, 72, 76, 73]
    public int[] dailyTemperatures(int[] T) {
        Stack<int[]> incStack = new Stack<>();
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            if (!incStack.empty() && T[i] > incStack.peek()[1]) {
                while (!incStack.empty() && T[i] > incStack.peek()[1]) {
                    int index = incStack.pop()[0];
                    result[index] = i - index;
                }
            }
            incStack.push(new int[]{i, T[i]});
        }
        return result;
    }
}
