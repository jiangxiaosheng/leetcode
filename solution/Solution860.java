import java.util.HashMap;
import java.util.Map;

public class Solution860 {
//    public boolean lemonadeChange(int[] bills) {
//        Map<Integer, Integer> change = new HashMap<>();
//        for (int bill : bills) {
//            if (bill == 5) {
//                change.put(5, change.getOrDefault(5, 0) + 1);
//            } else if (bill == 10) {
//                if (change.getOrDefault(5, 0) > 0) {
//                    change.put(5, change.get(5) - 1);
//                    change.put(10, change.getOrDefault(10, 0) + 1);
//                } else {
//                    return false;
//                }
//            } else {
//                if (change.getOrDefault(10, 0) > 0 && change.getOrDefault(5, 0) > 0) {
//                    change.put(10, change.get(10) - 1);
//                    change.put(5, change.get(5) - 1);
//                    change.put(20, change.getOrDefault(20, 0) + 1);
//                } else if (change.getOrDefault(10, 0) == 0 && change.getOrDefault(5, 0) > 2) {
//                    change.put(5, change.get(5) - 3);
//                    change.put(20, change.getOrDefault(20, 0) + 1);
//                } else {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    // optimized version
    public boolean lemonadeChange(int[] bills) {
        int[] change = new int[2];
        int five = 0, ten = 1;
        for (int bill : bills) {
            if (bill == 5) {
                change[five]++;
            } else if (bill == 10) {
                if (change[five] > 0) {
                    change[five]--;
                    change[ten]++;
                } else {
                    return false;
                }
            } else {
                if (change[ten] > 0 && change[five] > 0) {
                  change[five]--;
                  change[ten]--;
                } else if (change[ten] == 0 && change[five] > 2) {
                    change[five] -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
