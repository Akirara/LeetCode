public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length - 1;
        int m = matrix[0].length - 1;
        int low = matrix[0][0];
        int high = matrix[n][m] + 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            int j = m;
            for (int i = 0; i <= n; i++) {
                while (j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count += j + 1;
            }
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}