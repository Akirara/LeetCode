public class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if(len < 1)
        	return 0;
        int i = 0;
        for(i = 0; i < len; i++)
        	if(nums[i] >= target)
        		return i;

        return i;
    }
}