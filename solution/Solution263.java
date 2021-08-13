public class Solution263 {
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        int[] factors = new int[]{2, 3, 5};
        for (int f : factors) {
            while (n % f == 0) n = n / f;
        }
        return n == 1;
    }
}
