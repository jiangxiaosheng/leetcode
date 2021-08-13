import java.util.Arrays;
import java.util.Comparator;

public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        node[] nodes = new node[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nodes[i] = new node(nums[i], i);
        }
        Arrays.sort(nodes);
        System.out.println(Arrays.toString(nodes));
        for (int i = 0; i < nodes.length; ) {
            int j = i + 1;
            while (j < nodes.length && nodes[j].ele == nodes[i].ele) {
                j++;
            }
            for (int e = i + 1; e < j; e++) {
                if (nodes[e].index - nodes[e - 1].index <= k)
                    return true;
            }
            i = j;
        }
        return false;
    }

    static class node implements Comparable<node> {
        int ele, index;

        node(int e, int i) {
            ele = e;
            index = i;
        }

        @Override
        public int compareTo(node o) {
            if (this.ele != o.ele) return this.ele - o.ele;
            return this.index - o.index;
        }

        @Override
        public String toString() {
            return "{ele: " + ele + " index: " + index + "}";
        }
    }
}
