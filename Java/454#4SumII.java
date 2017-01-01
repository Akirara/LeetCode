public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int sum = 0;
        int len = A.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
               sum = A[i] + B[j];
               hm.put(sum, hm.getOrDefault(sum, 0) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                count += hm.getOrDefault(-(C[i] + D[j]), 0);
            }
        }
        return count;
    }
}