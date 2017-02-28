public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack<Integer> sk = new Stack<>();
        Map<Integer, Integer> hm = new HashMap<>();
        int[] res = new int[findNums.length];
        for (int n : nums) {
            while (!sk.empty() && n > sk.peek()) {
                hm.put(sk.pop(), n);
            }
            sk.push(n);
        }
        for (int i = 0; i < findNums.length; i++) {
            res[i] = hm.getOrDefault(findNums[i], -1);
        }
        return res;
    }
}