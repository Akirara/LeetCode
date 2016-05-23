/*
*	modified from 46#Permutation.java
*/
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ret = solve(nums, 0);
        return ret;
    }

    public List<List<Integer>> solve(int[] nums, int pos) {
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	if(pos == nums.length - 1) {
    		List<Integer> l = new ArrayList<Integer>();
    		l.add(nums[pos]);
    		ret.add(l);
    		return ret;
    	}
    	List<List<Integer>> tmp = new ArrayList<List<Integer>>();
    	tmp = solve(nums, pos + 1);
    	for(int i = 0; i < tmp.size(); i++) {
    		List<Integer> l = new ArrayList<Integer>();
    		l = tmp.get(i);
    		for(int j = 0; j < l.size(); j++) {
    			List<Integer> m = new ArrayList<Integer>();
    			m.addAll(l);
    			m.add(j, nums[pos]);
    			if(!ret.contains(m))
    				ret.add(m);
    		}
    		List<Integer> m = new ArrayList<Integer>();
    		m.addAll(l);
    		m.add(nums[pos]);
    		if(!ret.contains(m))
    			ret.add(m);
    	}
    	return ret;
    }
}

/*
*   swap recursion method (best solution)
*/
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int len = nums.length;
        dfs(ret, nums, 0, len - 1);
        return ret;
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
        return;
    }

    public boolean check(int[] nums, int begin, int end, int target) {
    	for(int i = begin; i < end; i++) {
    		if(nums[i] == target) {
    			return false;
    		}
    	}
    	return true;
    }

    public void dfs(List<List<Integer>> ret, int[] nums, int pos, int len) {
        if(pos == len) {
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i <= len; i++) {
                list.add(nums[i]);
            }
            ret.add(list);
            return;
        }
        for(int i = pos; i <= len; i++) {
        	if(!check(nums, pos, i, nums[i]))
        		continue;
           	swap(nums, pos, i);
           	dfs(ret, nums, pos + 1, len);
           	swap(nums, pos, i);
        }
    }
}