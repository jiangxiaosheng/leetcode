import java.util.Stack;

public class Solution232 {
    static class MyQueue {

        private final Stack<Integer> s1, s2;

        /** Initialize your data structure here. */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            s1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (!s2.empty())
                return s2.pop();
            while (!s1.empty())
                s2.add(s1.pop());
            return s2.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (s2.empty()) {
                while (!s1.empty())
                    s2.push(s1.pop());
            }
            return s2.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s1.empty() && s2.empty();
        }
    }

}
