import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution138 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node resHead = new Node(-1), t = head, h = resHead;
        Map<Node, Node> map = new HashMap<>();
        map.put(null, null);
        while (t != null) {
            h.next = new Node(t.val);
            h = h.next;
            map.put(h, t);
            t = t.next;
        }
        System.out.println(map);
        resHead = resHead.next;
        h = resHead;
        t = head;
        while (t != null) {
            h.random = map.get(t.random);
            h = h.next;
            t = t.next;
        }
        return resHead;
    }
}
