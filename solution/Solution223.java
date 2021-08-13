public class Solution223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        if (ax1 > bx1) return computeArea(bx1, by1, bx2, by2, ax1, ay1, ax2, ay2);
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);
        if (by1 >= ay2 || by2 <= ay1 || bx1 >= ax2) return area1 + area2;
        int overlap = (Math.min(ay2, by2) - Math.max(ay1, by1)) * (Math.min(bx2, ax2) - Math.max(bx1, ax1));
        return area1 + area2 - overlap;
    }
}
