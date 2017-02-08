public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, S, 0);
    }
    
    public int dfs(int[] nums, int S, int pos) {
        if (pos == nums.length) {
            return S == 0 ? 1 : 0;
        }
        return dfs(nums, S + nums[pos], pos + 1) + dfs(nums, S - nums[pos], pos + 1);
    }
}


public class Solution {
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (Math.abs(s) > sum) {
            return 0;
        }
        int len = 2 * sum + 1;
        int[] dp = new int[len];
        dp[sum] = 1;
        for (int n : nums) {
            int[] next = new int[len];
            for (int i = 0; i < len; i++) {
                if (dp[i] != 0) {
                    next[i + n] += dp[i];
                    next[i - n] += dp[i];
                }
            }
            dp = next;
        }
        return dp[sum + s];
    }
}


public class Solution {
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1); 
    }   

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1]; 
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n]; 
        return dp[s];
    }
}