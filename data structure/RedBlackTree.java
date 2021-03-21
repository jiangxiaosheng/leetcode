public class RedBlackTree {
    RedBlackNode root;
    private final RedBlackNode nil = RedBlackNode.nil;

    public RedBlackTree() {
        root = nil;
        root.parent = nil;
        root.left = nil;
        root.right = nil;
    }

    private void leftRotate(RedBlackNode x) {
        RedBlackNode y = x.right;
        x.right = y.left;
        if (y.left != nil) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == nil) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(RedBlackNode y) {
        RedBlackNode x = y.left;
        y.left = x.right;
        if (x.right != nil) {
            x.right.parent = y;
        }
        x.parent = y.parent;
        if (y.parent == nil) {
            root = x;
        } else if (y == y.parent.left) {
            y.parent.left = x;
        } else {
            y.parent.right = x;
        }
        x.right = y;
        y.parent = x;
    }

    public void insert(int val) {
        insert(val, true);
    }

    public void insert(int val, boolean sw) {
        RedBlackNode y = nil, x = root, z = new RedBlackNode(val);
        while (x != nil) {
            y = x;
            if (z.val < x.val) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;
        if (y == nil) {
            root = z;
        } else if (z.val < y.val) {
            y.left = z;
        } else {
            y.right = z;
        }
        if (sw)
            insertFixUp(z);
    }

    private void insertFixUp(RedBlackNode z) {
        while (z.parent.color == RedBlackNode.Color.Red) {
            if (z.parent == z.parent.parent.left) {
                RedBlackNode y = z.parent.parent.right;
                if (y.color == RedBlackNode.Color.Red) {
                    z.parent.color = RedBlackNode.Color.Black;
                    y.color = RedBlackNode.Color.Black;
                    z.parent.parent.color = RedBlackNode.Color.Red;
                    z = z.parent.parent;
                } else if (z == z.parent.right) {
                    z = z.parent;
                    leftRotate(z);
                } else {
                    z.parent.color = RedBlackNode.Color.Black;
                    z.parent.parent.color = RedBlackNode.Color.Red;
                    rightRotate(z.parent.parent);
                }
            } else {
                RedBlackNode y = z.parent.parent.left;
                if (y.color == RedBlackNode.Color.Red) {
                    z.parent.color = RedBlackNode.Color.Black;
                    y.color = RedBlackNode.Color.Black;
                    z.parent.parent.color = RedBlackNode.Color.Red;
                    z = z.parent.parent;
                } else if (z == z.parent.left) {
                    z = z.parent;
                    rightRotate(z);
                } else {
                    z.parent.color = RedBlackNode.Color.Black;
                    z.parent.parent.color = RedBlackNode.Color.Red;
                    leftRotate(z.parent.parent);
                }
            }
        }
        root.color = RedBlackNode.Color.Black;
    }

    public void delete(int val) {
        try {
            RedBlackNode x = findNode(val);
            bstDelete(x);
            deleteFixUp(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void bstDelete(RedBlackNode node) {
        RedBlackNode parent = node.parent;
        if (node == parent.left) {
            if (node.left == nil && node.right == nil) {
                parent.left = nil;
            } else if (node.left == nil) {
                parent.left = node.right;
                node.right.parent = parent;
            } else if (node.right == nil) {
                parent.left = node.left;
                node.left.parent = parent;
            } else {
                RedBlackNode temp = minimum(node.right);
                node.val = temp.val;
                bstDelete(temp);
            }
        } else {
            if (node.left == nil && node.right == nil) {
                parent.right = nil;
            } else if (node.left == nil) {
                parent.right = node.right;
                node.right.parent = parent;
            } else if (node.right == nil) {
                parent.right = node.left;
                node.left.parent = parent;
            } else {
                RedBlackNode temp = minimum(node.right);
                node.val = temp.val;
                bstDelete(temp);
            }
        }
    }

    private void deleteFixUp(RedBlackNode x) {
        while (x != root && x.color == RedBlackNode.Color.Black) {
            if (x == x.parent.left) {
                RedBlackNode s = x.parent.right;
                if (s.color == RedBlackNode.Color.Red) {
                    s.color = RedBlackNode.Color.Black;
                    x.parent.color = RedBlackNode.Color.Red;
                    leftRotate(x.parent);
                    s = x.parent.right;
                }
                if (s.left.color == RedBlackNode.Color.Black && s.right.color == RedBlackNode.Color.Black) {
                    s.color = RedBlackNode.Color.Red;
                    x = x.parent;
                } else {
                    if (s.right.color == RedBlackNode.Color.Black) {
                        s.left.color = RedBlackNode.Color.Black;
                        s.color = RedBlackNode.Color.Red;
                        rightRotate(s);
                        s = x.parent.right;
                    }
                    s.color = x.parent.color;
                    x.parent.color = RedBlackNode.Color.Black;
                    s.right.color = RedBlackNode.Color.Black;
                    leftRotate(x.parent);
                    x = root;

                }
            } else {
                RedBlackNode s = x.parent.left;
                if (s.color == RedBlackNode.Color.Red) {
                    s.color = RedBlackNode.Color.Black;
                    x.parent.color = RedBlackNode.Color.Red;
                    rightRotate(x.parent);
                    s = x.parent.left;
                }
                if (s.right.color == RedBlackNode.Color.Black && s.left.color == RedBlackNode.Color.Black) {
                    s.color = RedBlackNode.Color.Red;
                    x = x.parent;
                } else {
                    if (s.left.color == RedBlackNode.Color.Black) {
                        s.right.color = RedBlackNode.Color.Black;
                        s.color = RedBlackNode.Color.Red;
                        leftRotate(s);
                        s = x.parent.left;
                    }
                    s.color = x.parent.color;
                    x.parent.color = RedBlackNode.Color.Black;
                    s.left.color = RedBlackNode.Color.Black;
                    rightRotate(x.parent);
                    x = root;

                }
            }
            x.color = RedBlackNode.Color.Black;
        }
    }

    private RedBlackNode findNode(int val) throws Exception {
        if (root == nil) {
            throw new Exception("The Red-Black Tree is empty!");
        }
        RedBlackNode node = root;
        while (node != nil && val != node.val) {
            if (val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        if (node == nil) {
            throw new Exception("Element " + val + " is not in the Red-Black Tree!");
        }
        return node;
    }

    private RedBlackNode bstDelete(RedBlackNode node, int val) {
        if (node == nil) return node;
        else if (val < node.val) {
            RedBlackNode temp = bstDelete(node.left, val);
            node.left = temp;
            temp.parent = node;
        } else if (val > node.val) {
            RedBlackNode temp = bstDelete(node.right, val);
            node.right = temp;
            temp.parent = node;
        } else {
            if (node.left == nil && node.right == nil) {
                node = nil;
            } else if (node.left == nil) {
                node = node.right;
            } else if (node.right == nil) {
                node = node.left;
            } else {
                RedBlackNode temp = minimum(node.right);
                node.val = temp.val;
                RedBlackNode newRight = bstDelete(node.right, temp.val);
                node.right = newRight;
                newRight.parent = node;
            }
        }
        return node;
    }

    public RedBlackNode minimum(RedBlackNode root) {
        RedBlackNode temp = root;
        while (temp.left != nil) {
            temp = temp.left;
        }
        return temp;
    }

    public RedBlackNode maximum(RedBlackNode root) {
        RedBlackNode temp = root;
        while (temp.right != nil) {
            temp = temp.right;
        }
        return temp;
    }
}

class RedBlackNode {
    static RedBlackNode nil = new RedBlackNode();

    RedBlackNode parent;
    RedBlackNode left;
    RedBlackNode right;
    Color color;
    int val;

    enum Color {Red, Black}

    public RedBlackNode() {
        color = Color.Black;
    }

    public RedBlackNode(int val) {
        this(val, Color.Red, nil, nil, nil);
    }

    public RedBlackNode(int val, RedBlackNode parent, RedBlackNode left, RedBlackNode right) {
        this(val, Color.Red, parent, left, right);
    }

    public RedBlackNode(int val, Color color, RedBlackNode parent, RedBlackNode left, RedBlackNode right) {
        this.val = val;
        this.color = color;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
}

class RedBlackTreeHelper {
    private static String withColor(String str, RedBlackNode.Color color) {
        switch (color) {
            case Red:
                return "\u001b[31m" + str + "\u001b[0m";
            case Black:
                return "\u001b[30m" + str + "\u001b[0m";
        }
        return "";
    }

    public static int getTreeDepth(RedBlackNode root) {
        return root == RedBlackNode.nil ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
    }

    private static void writeArray(RedBlackNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        if (currNode == RedBlackNode.nil) return;
        res[rowIndex][columnIndex] = withColor(String.valueOf(currNode.val), currNode.color);

        int currLevel = ((rowIndex + 1) / 2);
        if (currLevel == treeDepth) return;
        int gap = treeDepth - currLevel - 1;

        if (currNode.left != RedBlackNode.nil) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        if (currNode.right != RedBlackNode.nil) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }

    public static void printTree(RedBlackNode root) {
        if (root == RedBlackNode.nil) System.out.println("EMPTY!");
        int treeDepth = getTreeDepth(root);

        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        String[][] res = new String[arrayHeight][arrayWidth];
        for (int i = 0; i < arrayHeight; i++) {
            for (int j = 0; j < arrayWidth; j++) {
                res[i][j] = " ";
            }
        }

        writeArray(root, 0, arrayWidth / 2, res, treeDepth);

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
}
