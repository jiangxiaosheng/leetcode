import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution281 {
    static public class ZigzagIterator {
        List<Iterator<Integer>> its = new ArrayList<>();
        int idx = 0;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            its.add(v1.iterator());
            its.add(v2.iterator());
        }

        public int next() {
            if (hasNext()) {
                int res =  its.get(idx).next();
                idx = (idx + 1) % its.size();
                return res;
            }
            return -1;
        }

        public boolean hasNext() {
            Iterator<Integer> it = its.get(idx);
            if (!it.hasNext()) {
                its.remove(it);
                if (its.isEmpty()) return false;
                if (idx == its.size()) idx = 0;
                return its.get(idx).hasNext();
            } else {
                return true;
            }
        }
    }
}
