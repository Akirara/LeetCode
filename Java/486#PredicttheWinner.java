public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int[][] max = new int[len][len];
        int[][] min = new int[len][len];
        for (int i = 0; i < len; i++) {
            max[i][0] = nums[i];
            min[i][0] = 0;
        }
        for (int i = 0; i < len - 1; i++) {
            max[i][i + 1] = Math.max(nums[i], nums[i + 1]);
            min[i][i + 1] = Math.min(nums[i], nums[i + 1]);
        }
        for (int i = 2; i < len; i++) {
            for (int j = 0; j + i < len; j++) {
                max[j][j + i] = Math.max(nums[j] + min[j + 1][j + i], nums[j + i] + min[j][j + i - 1]);
                min[j][j + i] = Math.min(max[j + 1][j + i], max[j][j + i - 1]);
            }
        }
        return max[0][len - 1] >= min[0][len - 1];
    }
}


public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j + i < len; j++) {
                dp[j][i + j] = Math.max(nums[j] - dp[j + 1][j + i], nums[j + i] - dp[j][j + i - 1]);
            }
        }
        return dp[0][len - 1] >= 0;
    }
}