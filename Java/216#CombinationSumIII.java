public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        dfs(ret, new ArrayList<Integer>(), 1, k, n);
        return ret;
    }
    
    public void dfs(List<List<Integer>> ret, List<Integer> list, int cur, int k, int sum) {
        if (k == 0) {
            if (sum == 0) {
                List<Integer> tmp = new ArrayList<Integer>(list);
                ret.add(tmp);
            }
            return;
        }
        for (int i = cur; i <= 9; i++) {
            list.add(i);
            dfs(ret, list, i + 1, k - 1, sum - i);
            list.remove(list.size() - 1);
        }
    }
}