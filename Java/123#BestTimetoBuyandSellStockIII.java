public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2)
        	return 0;
        int[] profit = new int[len];
        profit[0] = 0;
        for(int i = 1; i < len; i++) {
        	profit[i] = prices[i] - prices[i - 1];
        }
        int max = 0, first = 0, second = 0, tmp	= 0;
        for(int i = 1; i < len; i++) {
        	if(profit[i] <= 0)
        		continue; 
        	first = 0;
        	second = 0;
        	tmp = 0;
        	for(int j = 1; j < i; j++) {
        		tmp += profit[j];
        		if(tmp < 0)
        			tmp = 0;
        		else if(tmp > first)
        			first = tmp;
        	}
        	tmp = 0;
        	for(int k = i; k < len; k++) {
        		tmp += profit[k];
        		if(tmp < 0)
        			tmp =  profit[k];
        		else if(tmp > second)
        			second = tmp;
        	}
        	if(first + second > max)
        		max = first + second;
        }
        return max;
    }
}

/**
*	dp method
*/
public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2)
        	return 0;
        int[] forward = new int[len];
        int min = prices[0], max = 0;
        for(int i = 0; i < len; i++) {
        	if(prices[i] < min)
        		min = prices[i];
        	else if(prices[i] - min > max)
        		max = prices[i] - min;
        	forward[i] = max;
        }
        int ret = 0;
        max = prices[len - 1];
        min = 0;
        for(int i = len - 1; i >= 0; i--) {
        	if(prices[i] > max)
        		max = prices[i];
        	else if(prices[i] - max < min) {
        		min = prices[i] - max;
        		if(forward[i] - min > ret)
        			ret = forward[i] - min;
        	}
        }
        return ret;
    }
}