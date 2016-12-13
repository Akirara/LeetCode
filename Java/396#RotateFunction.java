public class Solution {
    public int maxRotateFunction(int[] A) {
        int len = A.length;
        int max = 0;
        int sum = 0;
        int tmp = 0;
        for (int i = 0; i < len; i++) {
            tmp += i * A[i];
            sum += A[i];
        }
        max = tmp;
        for (int i = 0; i < len - 1; i++) {
            tmp += len * A[i] - sum;
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }
}