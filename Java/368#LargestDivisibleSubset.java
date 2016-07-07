/**
*	my own method, use List<List<Integer>> to record the path
*/
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
    	int len = nums.length;
    	if(len == 0)
    		return new ArrayList<Integer>();
    	int[] dp = new int[len];
    	int maxLen = -1;
    	int maxPos = 0;
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	Arrays.sort(nums);
    	for(int i = 0; i < len; i++) {
    		dp[i] = 1;
    		int pos = 0;
    		int max = 0;
    		for(int j = 0; j < i; j++) {
    			if(nums[i] % nums[j] == 0 && dp[j] > max) {
    				max = dp[j];
    				pos = j;
    			}
    		}
    		dp[i] += max;
    		List<Integer> list = new ArrayList<Integer>();
    		if(dp[i] != 1) {
    			list.addAll(res.get(pos));
    		}
    		list.add(nums[i]);
    		res.add(list);
    		if(dp[i] > maxLen) {
    			maxLen = dp[i];
    			maxPos = i;
    		}
    	}
    	return res.get(maxPos);
    }
}

/**
*	NB method, use last[] to save last position
*/
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
    	int len = nums.length;
    	if(len == 0)
    		return new ArrayList<Integer>();
    	int[] dp = new int[len];
    	int[] last = new int[len];
    	int maxLen = -1;
    	int maxPos = 0;
    	Arrays.sort(nums);
    	for(int i = 0; i < len; i++) {
    		dp[i] = 1;
    		int pos = 0;
    		int max = 0;
    		for(int j = 0; j < i; j++) {
    			if(nums[i] % nums[j] == 0 && dp[j] > max) {
    				max = dp[j];
    				pos = j;
    			}
    		}
    		dp[i] += max; 
    		last[i] = dp[i] == 1 ? -1 : pos;
    		if(dp[i] > maxLen) {
    			maxLen = dp[i];
    			maxPos = i;
    		}
    	}
    	List<Integer> ret = new ArrayList<Integer>();
    	while(maxPos != -1) {
    		ret.add(0, nums[maxPos]);
    		maxPos = last[maxPos];
    	}
    	return ret;
    }
}