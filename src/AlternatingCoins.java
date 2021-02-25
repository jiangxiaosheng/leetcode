public class AlternatingCoins {

    public int solution(int[] A) {
        // write your code in Java SE 8
        int minTimes = A.length + 1;

        minTimes = Math.min(calculateTimes(A, 1), minTimes);
        minTimes = Math.min(calculateTimes(A, 0), minTimes);

        return minTimes;
    }

    private int calculateTimes(int[] A, int firstValue) {
        int times = 0;
        int currentValue = firstValue;
        for (int a : A) {
            if (currentValue == 1 && a == 0)
                times++;
            if (currentValue == 0 && a == 1)
                times++;
            currentValue = 1 - currentValue;
        }
        return times;
    }

    public static void main(String[] args) {
        System.out.println(new AlternatingCoins().solution(new int[]{0, 1, 1, 0}));
    }
}
