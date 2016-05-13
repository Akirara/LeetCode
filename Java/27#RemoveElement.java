public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if(len == 0)
        	return len;
        int index = len - 1;
        int i = 0, j = index;
        for(i = 0; i <= index; i++) {
        	if(nums[i] == val) {
        		for(j = index; j >= i; j--) {
        			if(nums[j] != val) {
        				nums[i] = nums[j];
        				index = j - 1;
        				break;
        			}
        		}
        		if(j == i - 1)
        			return i;
        	}
        }
        return i;
    }
}

/*
*	use two pointers
*/
public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if(len == 0)
        	return len;
        int low = 0;
        int high = len - 1;
        while(low <= high) {
        	while(low <= high && nums[low] != val)
        		low++;
        	while(low <= high && nums[high] == val)
        		high--;
        	if(low <= high) {
        		nums[low] = nums[high];
        		low++;
        		high--;
        	}
        }
        return low;
    }
}