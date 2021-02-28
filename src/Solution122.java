public class Solution122 {
    // [7,1,5,3,6,4]
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int buy = -1, sell = -1, profit = 0;
        while (buy < prices.length - 1 && sell < prices.length - 1) {
            buy = findMin(prices, sell + 1);
            if (buy >= prices.length - 1)
                break;
            sell = findMax(prices, buy + 1);
            profit += prices[sell] - prices[buy];
        }
        return profit;
    }

    private int findMin(int[] prices, int curr) {
        int i = curr + 1;
        while (i < prices.length) {
            if (prices[i] < prices[i - 1]) {
                i++;
            } else {
                break;
            }
        }
        return i - 1;
    }

    private int findMax(int[] prices, int curr) {
        int i = curr + 1;
        while (i < prices.length) {
            if (prices[i] > prices[i - 1]) {
                i++;
            } else {
                break;
            }
        }
        return i - 1;
    }
}
