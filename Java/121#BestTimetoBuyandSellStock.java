public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0)
        	return 0;
        int minPrice = prices[0];
        int profit = 0;
        for(int i = 1; i < len; i++) {
        	if(prices[i] < minPrice)
        		minPrice = prices[i];
        	else if(prices[i] - minPrice > profit)
        		profit = prices[i] - minPrice;
        }
        return profit;
    }
}