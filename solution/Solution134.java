public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0, n = gas.length;
        while (i < n) {
            int sumGas = 0;
            int cnt = 0;
            int idx;
            while (cnt < n) {
                idx = (i + cnt) % n;
                sumGas += gas[idx] - cost[idx];
                if (sumGas < 0) break;
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}
