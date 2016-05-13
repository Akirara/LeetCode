public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        if(len < 4)
        	return ret;

        Arrays.sort(nums);
        for(int i = 0; i < len - 3;) {
        	for(int j = i + 1; j < len - 2;) {
        		int low = j + 1;
        		int high = len - 1;
        		int sum = 0;

        		while(low < high) {
        			sum = nums[i] + nums[j] + nums[low] + nums[high];
        			if(sum == target) {
    					List<Integer> tmp = new ArrayList<Integer>();
    					tmp.add(nums[i]);
    					tmp.add(nums[j]);
    					tmp.add(nums[low]);
    					tmp.add(nums[high]);
    					if(!ret.contains(tmp))
    						ret.add(tmp);
        				low++;
        				while(low < high && nums[low] == nums[low - 1])
        					low++;
        				high--;
        				while(low < high && nums[high] == nums[high] + 1)
        					high--;
        			}
        			else if(sum < target) {
        				low++;
        				while(low < high && nums[low] == nums[low - 1])
        					low++;
        			}
        			else {
        				high--;
        				while(low < high && nums[high] == nums[high] + 1)
        					high--;
        			}
        		}
        		j++;
        		while(j < len - 2 && nums[j] == nums[j - 1])
        			j++;
        	}
        	i++;
        	while(i < len - 3 && nums[i] == nums[i - 1])
        		i++;
        }
        return ret;
    }
}