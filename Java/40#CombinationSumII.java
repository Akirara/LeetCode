/*
*	recursion method
*/
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        int len = candidates.length;
        if(len == 0)
        	return res;
        Arrays.sort(candidates);
        List<Integer> tmp = new LinkedList<Integer>();
        solve(res, tmp, candidates, target, 0);
        return res;
    }

    public void solve(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int target, int pos) {
    	if(target == 0) {
    		if(!res.contains(tmp))
    			res.add(tmp);
    		return;
    	}
    	if(pos == candidates.length)
    		return;
    	if(target < candidates[pos])
    		return;

    	List<Integer> l = new LinkedList<Integer>();
    	int val = candidates[pos];
    	l.addAll(tmp);
    	l.add(val);
    	pos++;
    	solve(res, l, candidates, target - val, pos);
    	solve(res, tmp, candidates, target, pos);
    }
}

