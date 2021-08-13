import java.util.*;

public class Solution451 {
    static class Status implements Comparable<Status> {
        char val;
        int freq;

        Status(char v, int f) {
            val = v;
            freq = f;
        }

        @Override
        public int compareTo(Status o) {
            return o.freq - freq;
        }
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Status> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(new Status(entry.getKey(), entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Status st = pq.poll();
            for (int i = 0; i < st.freq; i++)
                sb.append(st.val);
        }
        return sb.toString();
    }
}
