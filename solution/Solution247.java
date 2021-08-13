import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution247 {
    public List<String> findStrobogrammatic(int n) {
        Queue<String> q = new LinkedList<>();
        q.offer("");
        if (n % 2 == 0) {
            gen(n, q);
            return new ArrayList<>(q);
        }
        gen(n - 1, q);
        int size = q.size();
        StringBuilder sb;
        for (int i = 0; i < size; i++) {
            sb = new StringBuilder(q.poll());
            int idx = sb.length() / 2;
            sb.insert(idx, '0');
            q.offer(sb.toString());
            sb.setCharAt(idx, '1');
            q.offer(sb.toString());
            sb.setCharAt(idx, '8');
            q.offer(sb.toString());
        }
        return new ArrayList<>(q);
    }

    private void gen(int num, Queue<String> res) {
        int cur = 0;
        while (cur < num) {
            int size = res.size(), idx = cur / 2;
            StringBuilder sb;
            for (int i = 0; i < size; i++) {
                sb = new StringBuilder(res.poll());
                res.offer(sb.insert(idx, '1').insert(idx + 1, '1').toString());
                sb.setCharAt(idx, '8');
                sb.setCharAt(idx + 1, '8');
                res.offer(sb.toString());
                sb.setCharAt(idx, '6');
                sb.setCharAt(idx + 1, '9');
                res.offer(sb.toString());
                sb.setCharAt(idx, '9');
                sb.setCharAt(idx + 1, '6');
                res.offer(sb.toString());
                if (cur > 0) {
                    sb.setCharAt(idx, '0');
                    sb.setCharAt(idx + 1, '0');
                    res.offer(sb.toString());
                }
            }
            cur += 2;
        }
    }
}
