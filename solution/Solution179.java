import java.util.Arrays;

public class Solution179 {
    public String largestNumber(int[] nums) {
        nums = Arrays.stream(nums).boxed().sorted(this::compare).mapToInt(i -> i).toArray();
        StringBuilder sb = new StringBuilder();
        for (int i : nums) {
            sb.append(i);
        }
        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
//        if (Integer.parseInt(sb.toString()) == 0) return "0";
        return sb.toString();
    }

    private int compare(int a, int b) {
        String sa = "" + a, sb = "" + b;
        int c = -sa.compareTo(sb);
        if (sa.charAt(0) == sb.charAt(0)) {
            return -(sa + sb).compareTo(sb + sa);
        } else {
            return c;
        }
    }
}
