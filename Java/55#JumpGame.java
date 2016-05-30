public class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if(len == 0)
        	return true;
        int reach = 0;
        for(int i = 0; i <= reach; i++) {
        	if(nums[i] + i > reach)
        		reach = nums[i] + i;
        	if(reach >= len - 1)
        		return true;
        }
        return false;
    }
}