import java.util.HashMap;
import java.util.Stack;

public class Solution155 {
    static class MinStack {

        private final Stack<Integer> dataStack, minStack;
        int min;

        /** initialize your data structure here. */
        public MinStack() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            dataStack.push(x);
            min = Math.min(min, x);
            minStack.push(min);
        }

        public void pop() {
            dataStack.pop();
            minStack.pop();
            min = dataStack.empty() ? Integer.MAX_VALUE : minStack.peek();
        }

        public int top() {
            return dataStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
