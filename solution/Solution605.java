public class Solution605 {
//    public boolean canPlaceFlowers(int[] flowerbed, int n) {
//        int count = 0;
//        for (int i = 0; i < flowerbed.length; i++) {
//            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
//                flowerbed[i] = 1;
//                count++;
//            }
//        }
//        return count >= n;
//    }

    // optimized version
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                i += 2;
                count++;
            } else {
                i++;
            }
        }
        return count >= n;
    }
}
