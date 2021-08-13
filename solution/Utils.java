import java.util.*;

public class Utils {
    /*
        树的结构示例：
                  1
                /   \
              2       3
             / \     / \
            4   5   6   7
    */
    // 用于获得树的层数
    public static int getTreeDepth(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
    }

    private static void writeArray(TreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // 保证输入的树不为空
        if (currNode == null) return;
        // 先将当前节点保存到二维数组中
        res[rowIndex][columnIndex] = String.valueOf(currNode.val);

        // 计算当前位于树的第几层
        int currLevel = ((rowIndex + 1) / 2);
        // 若到了最后一层，则返回
        if (currLevel == treeDepth) return;
        // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
        int gap = treeDepth - currLevel - 1;

        // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
        if (currNode.left != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
        if (currNode.right != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }

    public static void printTree(TreeNode root) {
        if (root == null) System.out.println("EMPTY!");
        // 得到树的深度
        int treeDepth = getTreeDepth(root);

        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
        // 作为整个二维数组的宽度
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        // 用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        // 对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i++) {
            for (int j = 0; j < arrayWidth; j++) {
                res[i][j] = " ";
            }
        }

        // 从根节点开始，递归处理整个树
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth / 2, res, treeDepth);

        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
        for (String[] line : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2 : line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }

    //前序+中序
    public static TreeNode createTree(int[] pre, int[] in) {
        return createTreeHelp(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    //前序+中序
    private static TreeNode createTreeHelp(int[] pre, int[] in, int lp, int hp, int li, int hi) {
        if (lp > hp || li > hi) return null;
        TreeNode root = new TreeNode(pre[lp]);
        int mid_in = getIndex(in, pre[lp]);
        int length = mid_in - li;
        root.left = createTreeHelp(pre, in, lp + 1, lp + length, li, mid_in - 1);
        root.right = createTreeHelp(pre, in, lp + length + 1, hp, mid_in + 1, hi);
        return root;
    }

    private static int getIndex(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public static ListNode createLinkedList(int[] nums) {
        if (nums.length == 0) return null;
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for (int n : nums) {
            cur.next = new ListNode(n);
            cur = cur.next;
        }
        head = head.next;
        return head;
    }

    public static void printLinkedList(ListNode h) {
        if (null == h) return;
        ListNode cur = h;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.print("\b\b\n");
    }

    public static TreeNode buildTree(Integer[] vals) {
        if (vals.length == 0 || vals[0] == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        int p = 0;
        TreeNode root = new TreeNode(vals[p++]);
        queue.offer(root);
        while (p < vals.length) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (p >= vals.length) break;
                Integer v1 = vals[p++], v2 = null;
                if (p < vals.length)
                    v2 = vals[p++];
                if (v1 != null) {
                    curr.left = new TreeNode(v1);
                    queue.offer(curr.left);
                }
                if (v2 != null) {
                    curr.right = new TreeNode(v2);
                    queue.offer(curr.right);
                }
            }
        }
        return root;
    }

    public static <T> void printStack(Stack<T> stack) {
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    public static List<Integer> inOrderWalk(TreeNode root) {
        TreeNode curr = root;
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while (curr != null || !stk.isEmpty()) {
            while (curr != null) {
                stk.push(curr);
                curr = curr.left;
            }
            curr = stk.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }
}

class TreeNode implements Comparable<TreeNode> {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode() {
    }

    public void setValue(int v) {
        val = v;
    }

    @Override
    public int compareTo(TreeNode o) {
        return Integer.compare(val, o.val);
    }

    @Override
    public String toString() {
        return val + "";
    }
}

class Reader4 {
    public int read4(char[] buf) {
        return -1;
    }
}