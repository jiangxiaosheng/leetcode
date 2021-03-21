import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution78 {
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        res.add(new ArrayList<>());
//        for (int num : nums) {
//            List<List<Integer>> copy = new ArrayList<>(res);
//            for (List<Integer> l : copy) {
//                List<Integer> t = new ArrayList<>(l);
//                t.add(num);
//                res.add(new ArrayList<>(t));
//            }
//        }
//        return res;
//    }

    // backtrack version
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new LinkedList<>(), res, 0);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> paths, List<List<Integer>> res, int start) {
        res.add(new ArrayList<>(paths));
        for (int i = start; i < nums.length; i++) {
            paths.add(nums[i]);
            backtrack(nums, paths, res, i + 1);
            paths.remove(paths.size() - 1);
        }
    }
}
