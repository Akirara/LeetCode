public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;

        if(len < 2)
        	return len;

        int index = 1;
        int now = nums[0];

        for(int i = 1; i < len; i++) {
        	if(nums[i] != now) {
        		nums[index] = nums[i];
        		now = nums[index];
        		index++;
        	}
        }
        return index;
    }
}