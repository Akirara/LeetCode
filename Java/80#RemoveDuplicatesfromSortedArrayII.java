public class Solution {
    public int removeDuplicates(int[] nums) {
		int len = nums.length;
		if(len == 0)
			return 0;
		int pos = 1;
		int count = 1;
		for(int i = 1; i < len; i++) {
			if(nums[i] != nums[pos - 1]) {
				nums[pos] = nums[i];
				pos++;
				count = 1;
			}
			else if(count < 2) {
				nums[pos] = nums[i];
				pos++;
				count++;
			}
		}
		return pos;
    }
}