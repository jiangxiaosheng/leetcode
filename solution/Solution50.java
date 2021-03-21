public class Solution50 {
    public double myPow(double x, int n) {
        long N = n;
        if (x == 0) {
            if (N == 0)
                return 1.;
            else
                return 0.;
        }
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }
        double ans = 1.0, x_contribution = x;
        while (N > 0) {
            if (N % 2 == 1) {
                ans *= x_contribution;
            }
            x_contribution *= x_contribution;
            N /= 2;
        }
        return ans;
    }
}
