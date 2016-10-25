public class Solution {
    public List<Integer> getRow(int rowIndex) {
		List<Integer> ret = new ArrayList();
		List<Integer> tmp = new ArrayList();

		ret.add(1);

		if(rowIndex == 0) {
			return ret;
		}

		for(int i = 0; i < rowIndex; ++i) {
			tmp.clear();
			tmp.add(1);

			for(int j = 0; j < ret.size() - 1; ++j) {
				tmp.add(ret.get(j) + ret.get(j + 1));
			}

			tmp.add(1);
			ret.clear();
			ret.addAll(tmp);
		}

		return ret;
    }
}