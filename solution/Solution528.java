import java.util.Random;

public class Solution528 {
    static class Solution {

        Random random = new Random();
        int[] pre;
        int sum = 0;

        public Solution(int[] w) {
            pre = new int[w.length];
            for (int i = 0; i < w.length; i++) {
                sum += w[i];
                pre[i] = sum;
            }
        }

        public int pickIndex() {
            int score = random.nextInt(sum);
            int lo = 0, hi = pre.length - 1, mid;
            while (lo != hi) {
                mid = (lo + hi) >> 1;
                if (score >= pre[mid]) lo = mid + 1;
                else hi = mid;
            }
            return lo;
        }
    }
}
