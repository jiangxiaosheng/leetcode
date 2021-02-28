import java.util.Arrays;

public class Solution1005 {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int sum = 0, minAbs = 200;
        for (int a : A) {
            if (K > 0 && a < 0) {
                sum += -a;
                K--;
            } else {
                sum += a;
            }
            if (Math.abs(a) < minAbs) {
                minAbs = Math.abs(a);
            }
        }
        if (K % 2 == 1) {
            sum -= 2 * minAbs;
        }
        return sum;
    }
}
