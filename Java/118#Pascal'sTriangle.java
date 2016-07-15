public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList();
        if(numRows == 0)
            return ret;
        ret.add(Arrays.asList(1));
        for(int i = 1; i < numRows; ++i) {
            List<Integer> list = ret.get(ret.size() - 1);
            List<Integer> tmp = new ArrayList();
            tmp.add(1);
            for(int j = 0; j < i - 1; ++j) {
                tmp.add(list.get(j) + list.get(j + 1));
            }
            tmp.add(1);
            ret.add(tmp);
        }
        return ret;
    }
}