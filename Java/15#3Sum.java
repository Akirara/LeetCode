public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
        
        int len = nums.length;

        if(len < 3)
        	return ret;

        Arrays.sort(nums);

        for(int i = 0; i < len - 2; i++) {
        	while(i > 0 && i < len - 2 && nums[i] == nums[i - 1])
        		i++;

        	int low = i + 1;
        	int high = len - 1;

        	while(low < high) {
	        	int sum = nums[i] + nums[low] + nums[high];
	        	if(sum == 0) {
	        		List<Integer> tmp = new ArrayList<Integer>();
	        		tmp.add(nums[i]);
	    			tmp.add(nums[low]);
	    			tmp.add(nums[high]);
	    			if(!ret.contains(tmp)) {
	    				ret.add(tmp);
	    			}
	    			low++;
	    			high--;
	    			while(low < high && nums[low] == nums[low - 1])
	    				low++;
	    			while(low < high && nums[high] == nums[high + 1])
	    				high--;
	        	}
	        	else if(sum < 0) {
	        		low++;
	        		while(low < high && nums[low] == nums[low - 1])
	    				low++;
	        	}
	        	else {
	        		high--;
	        		while(low < high && nums[high] == nums[high + 1])
	    				high--;
	        	}
	        }
        }

        return ret;
    }
}