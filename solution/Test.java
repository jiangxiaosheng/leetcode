import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        TreeNode root = Utils.buildTree(new Integer[]{3,5,1,6,2,9,8,null,null,7,4});
        Utils.printTree(root);
        TreeNode root2 = Utils.buildTree(new Integer[]{3,5,1,6,7,4,2,null,null,null,null,null,null,9,8});
        Solution872 solution872 = new Solution872();
        solution872.leafSimilar(root, root2);
    }
}
