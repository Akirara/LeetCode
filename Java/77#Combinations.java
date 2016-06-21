public class Solution {
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> l = new ArrayList<Integer>();
        dfs(ret, l, n, k);
        return ret;
    }

    public void dfs(List<List<Integer>> ret, List<Integer> l, int n, int k) {
    	if(n < k) {
    		return;
    	}
    	if(k == 0) {
    		ret.add(l);
    		return;
    	}
    	List<Integer> tmp = new ArrayList<Integer>();
    	tmp.addAll(l);
    	tmp.add(0, n);
    	dfs(ret, l, n - 1, k);
    	dfs(ret, tmp, n - 1, k - 1);
    	return;
    }
}