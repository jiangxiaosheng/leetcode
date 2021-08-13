public class Solution117 {
    public Node connect(Node root) {
        Node leftMost = root;
        while (leftMost != null) {
            Node head = leftMost, tmp = leftMost, nextTail = new Node();
            while (head != null) {
                Node l = head.left, r = head.right;
                if (l == null && r == null) {
                    head = head.next;
                    continue;
                }
                if (l != null && r != null) {
                    nextTail.next = l;
                    l.next = r;
                    nextTail = r;
                } else if (l != null) {
                    nextTail.next = l;
                    nextTail = l;
                } else {
                    nextTail.next = r;
                    nextTail = r;
                }
                Node uncle = head.next;
                if (uncle != null) {
                    Node cousin = uncle.left == null ? uncle.right : uncle.left;
                    if (cousin != null) {
                        nextTail.next = cousin;
                        nextTail = nextTail.next;
                    }
                }
                head = uncle;
            }
            nextTail.next = null;
            leftMost = tmp.left == null ? tmp.right : tmp.left;
            while (leftMost == null) {
                tmp = tmp.next;
                if (tmp == null) break;
                leftMost = tmp.left == null ? tmp.right : tmp.left;
            }
        }
        return root;
    }


}
