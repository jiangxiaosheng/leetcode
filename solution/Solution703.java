import java.util.PriorityQueue;

public class Solution703 {
    static class KthLargest {

        int k;
        PriorityQueue<Integer> pq;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>();
            for (int i : nums) {
                pq.offer(i);
                if (pq.size() > k) pq.poll();
            }
        }

        public int add(int val) {
            pq.offer(val);
            while (pq.size() > k) pq.poll();
            return pq.peek();
        }
    }
}
