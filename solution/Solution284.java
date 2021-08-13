import java.util.Iterator;

public class Solution284 {
    static class PeekingIterator implements Iterator<Integer> {
        Iterator<Integer> it;
        Integer pk = null;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            it = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (pk == null) {
                pk = next();
            }
            return pk;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (pk != null) {
                Integer cur = pk;
                pk = null;
                return cur;
            }
            return it.next();
        }

        @Override
        public boolean hasNext() {
            return it.hasNext() || pk != null;
        }
    }
}
