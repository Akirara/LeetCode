public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        int n = nums.length;
        dfs(ret, list, nums, n);
        return ret;
    }

    public void dfs(List<List<Integer>> ret, List<Integer> list, int[] nums, int n) {
    	if(n == 0) {
    		ret.add(list);
    		return;
    	}
    	List<Integer> tmp = new ArrayList<Integer>();
    	tmp.addAll(list);
    	tmp.add(0, nums[n - 1]);
    	dfs(ret, list, nums, n - 1);
    	dfs(ret, tmp, nums, n - 1);
    	return;
    }
}