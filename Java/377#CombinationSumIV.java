public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] count = new int[target + 1];
        count[0] = 1;
        for (int i = 0; i < target; i++) {
            for (int n : nums) {
                if (i + n <= target) {
                    count[i + n] += count[i];
                }
            }
        }
        return count[target];
    }
}


public class Solution {
    int[] count;
    public int combinationSum4(int[] nums, int target) {
        count = new int[target + 1];
        Arrays.fill(count, -1);
        count[0] = 1;
        return dp(nums, target);
    }
    
    public int dp(int[] nums, int target) {
        if (count[target] != -1) {
            return count[target];
        }
        int ret = 0;
        for (int n : nums) {
            if (target >= n) {
                ret += dp(nums, target - n);
            }
        }
        count[target] = ret;
        return ret;
    }
}