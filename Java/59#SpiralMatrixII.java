public class Solution {
    public int[][] generateMatrix(int n) {
 		int[][] matrix = new int[n][n];
 		int count = 1;
 		int i = 0, j = 0;
 		for(i = 0; i <= n / 2; i++) {
 			int k = 2 * i;
 			for(j = i; k < n && j < n - i; j++, count++)
 				matrix[i][j] = count;
 			for(j = i + 1; k < n && j < n - i; j++, count++)
 				matrix[j][n - i - 1] = count;
 			for(j = n - i - 2; k + 1 < n && j >= i; j--, count++)
 				matrix[n - i - 1][j] = count;
 			for(j = n - i - 2; k + 1 < n && j > i; j--, count++)
 				matrix[j][i] = count;
 		}
 		return matrix;
    }
}