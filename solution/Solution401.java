import java.util.ArrayList;
import java.util.List;

public class Solution401 {

//    int[] minuteDigits = new int[]{32, 16, 8, 4, 2, 1};
//    int[] hoursDigits = new int[]{8, 4, 2, 1};
//
//    public List<String> readBinaryWatch(int turnedOn) {
//        List<String> res = new ArrayList<>();
//        for (int i = 0; i <= 3; i++) {
//            int j = turnedOn - i;
//            if (j >= 6) continue;
//            List<Integer> hours = new ArrayList<>(), minutes = new ArrayList<>();
//            searchHours(i, 0, hours, 0, 0);
//            searchMinutes(j, 0, minutes, 0, 0);
//            for (int h : hours) {
//                for (int m : minutes) {
//                    res.add(String.format("%d:%02d", h, m));
//                }
//            }
//        }
//        return res;
//    }
//
//    private void searchMinutes(int turnedOn, int currDigits, List<Integer> res, int curr, int idx) {
//        if (idx == minuteDigits.length) {
//            if (currDigits == turnedOn && curr < 60) res.add(curr);
//            return;
//        }
//        if (currDigits > turnedOn) return;
//        searchMinutes(turnedOn, currDigits, res, curr, idx + 1);
//        searchMinutes(turnedOn, currDigits + 1, res, curr + minuteDigits[idx], idx + 1);
//    }
//
//    private void searchHours(int turnedOn, int currDigits, List<Integer> res, int curr, int idx) {
//        if (idx == hoursDigits.length) {
//            if (currDigits == turnedOn && curr < 12) res.add(curr);
//            return;
//        }
//        if (currDigits > turnedOn) return;
//        searchHours(turnedOn, currDigits, res, curr, idx + 1);
//        searchHours(turnedOn, currDigits + 1, res, curr + hoursDigits[idx], idx + 1);
//    }

    // a more simple way
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                    res.add(String.format("%d:%02d", i, j));
                }
            }
        }
        return res;
    }
}
