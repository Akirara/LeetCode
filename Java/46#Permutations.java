/*
*   insert iteration method
*/
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int len = nums.length;
        if(len == 0)
        	return ret;
        List<Integer> tmp = new ArrayList<Integer>();
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        List<Integer> m = new ArrayList<Integer>();
        tmp.add(nums[0]);
        ret.add(tmp);
        for(int i = 1; i < len; i++) {
        	l = new ArrayList<List<Integer>>();
        	for(int j = 0; j < ret.size(); j++) {
        		tmp = ret.get(j);
        		m = new ArrayList<Integer>();
        		m.addAll(tmp);
        		m.add(nums[i]);
        		l.add(m);
        		for(int k = tmp.size() - 1; k >= 0; k--) {
        			m = new ArrayList<Integer>();
        			m.addAll(tmp);
        			m.add(k, nums[i]);
        			l.add(m);
        		}
        	}
        	ret.clear();
        	ret.addAll(l);
        }
        return ret;
    }
}

/*
*	insert recursion method
*/
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
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
    			ret.add(m);
    		}
    		List<Integer> m = new ArrayList<Integer>();
    		m.addAll(l);
    		m.add(nums[pos]);
    		ret.add(m);
    	}
    	return ret;
    }
}

/*
*   swap recursion method (best solution)
*/
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
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
            swap(nums, pos, i);
            dfs(ret, nums, pos + 1, len);
            swap(nums, pos, i);
        }
    }
}