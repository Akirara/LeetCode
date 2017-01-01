public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = divideConquer(input, 0, input.length());
        return ret;
    }
    
    public List<Integer> divideConquer(String s, int start, int end) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int index = start; index < end; index++) {
            if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                continue;
            }
            List<Integer> left = divideConquer(s, start, index);
            List<Integer> right = divideConquer(s, index + 1, end);
            if (s.charAt(index) == '+') {
                for (int i = 0; i < left.size(); i++) {
                    for (int j = 0; j < right.size(); j++) {
                        ret.add(left.get(i) + right.get(j));
                    }
                }
            } else if (s.charAt(index) == '-') {
                for (int i = 0; i < left.size(); i++) {
                    for (int j = 0; j < right.size(); j++) {
                        ret.add(left.get(i) - right.get(j));
                    }
                }
            } else {
                for (int i = 0; i < left.size(); i++) {
                    for (int j = 0; j < right.size(); j++) {
                        ret.add(left.get(i) * right.get(j));
                    }
                }
            }
        }
        if (ret.size() == 0) {
            ret.add(Integer.parseInt(s.substring(start, end)));
        }
        return ret;
    }
}