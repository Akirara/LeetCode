public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
 		List<List<Integer>> ret = new ArrayList<List<Integer>>();
 		List<Integer> l = new ArrayList<Integer>();
 		Arrays.sort(nums);
 		addSubsets(ret, l, nums, 0);
 		return ret;       
    }

    public void addSubsets(List<List<Integer>> ret, List<Integer> tmp, int[] nums, int pos) {
    	if(pos == nums.length) {
    		if(!ret.contains(tmp)) {
    			ret.add(tmp);
    		}
    		return;
    	}
    	List<Integer> l = new ArrayList<Integer>();
    	l.addAll(tmp);
    	l.add(nums[pos]);
    	addSubsets(ret, l, nums, pos + 1);
    	addSubsets(ret, tmp, nums, pos + 1);
    }
}