public class Solution233 {
    public int countDigitOne(int n) {
        int high = n, low = 0, num = 1, cur, cnt = 0;
        while (high != 0) {
            cur = high % 10;
            high /= 10;
            if (cur == 0) cnt += high * num;
            else if (cur == 1) cnt += high * num + 1 + low;
            else cnt += (high + 1) * num;
            low = cur * num + low;
            num *= 10;
        }
        return cnt;
    }
}
