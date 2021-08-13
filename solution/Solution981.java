import java.util.*;

public class Solution981 {
    static class TimeMap {

        static class ValueTimestamp implements Comparable<ValueTimestamp> {
            String value;
            int timestamp;

            ValueTimestamp(String v, int t) {
                value = v;
                timestamp = t;
            }

            @Override
            public int compareTo(ValueTimestamp o) {
                return timestamp - o.timestamp;
            }
        }

        Map<String, List<ValueTimestamp>> map;

        /** Initialize your data structure here. */
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(new ValueTimestamp(value, timestamp));
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) return "";
            List<ValueTimestamp> list = map.get(key);
            if (timestamp < list.get(0).timestamp) return "";
            int lo = 0, hi = list.size() - 1, mid = (lo + hi) >> 1;
            while (lo <= hi) {
                if (list.get(mid).timestamp == timestamp) return list.get(mid).value;
                if (list.get(mid).timestamp < timestamp) lo = mid + 1;
                else hi = mid - 1;
                mid = (lo + hi) >> 1;
            }
            return list.get(lo - 1).value;
        }
    }
}
