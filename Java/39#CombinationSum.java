/*
*   recursion
*/
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(candidates.length == 0)
            return ret;
        Arrays.sort(candidates);
        List<Integer> tmp = new ArrayList<Integer>();
        findList(ret, tmp, candidates, target, 0);
        return ret;
    }

    public void findList(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int target, int pos) {
        if(target == 0) {
            if(!res.contains(tmp)) {
                res.add(tmp);
            }
            return;
        }
        if(pos == candidates.length)
            return;
        if(target < candidates[pos])
            return;
        for(int i = 0; target - i * candidates[pos] >= 0; i++) {
            List<Integer> l = new ArrayList<Integer>();
            l.addAll(tmp);
            for(int j = 0; j < i; j++) {
                l.add(candidates[pos]);
            }
            findList(res, l, candidates, target - i * candidates[pos], pos + 1);
        }
    }
}