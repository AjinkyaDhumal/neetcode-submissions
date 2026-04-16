class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int minLeft = prices[0], maxRight = prices[1];
        int maxProfit = Math.max(0, (maxRight - minLeft));
        if (prices.length == 2) return maxProfit;
        for (int i = 1, j = 2; j < prices.length; i++,j++) {
            if (prices[i] < minLeft) {
                minLeft = prices[i];
                maxRight = prices[j];
            } else if (prices[j] > maxRight) {
                maxRight = prices[j];
            }
            maxProfit = Math.max(maxProfit, (maxRight - minLeft));
        }
        return maxProfit;
    }
}

//3, 5, 6, 11, 7, 2, 12, 14, 1, 3, 4, 8