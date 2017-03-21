// use binary search  O(nlogn)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        
        for(int i = 0; i < nums.length; i++) {
            int index = Arrays.binarySearch(dp, 0, len, nums[i]);
            
            if(index < 0) {
                index = -(index + 1);
                dp[index] = nums[i];
                if(index == len) {
                    len++;
                }
            }
        }
        
        return len;
    }
}


// DP O(n^2)
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int maxLen = 0;
        
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        for (int n : dp) {
            maxLen = Math.max(maxLen, n);
        }
        
        return maxLen;
    }
}