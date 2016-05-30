/*
*	idiot method
*/
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] ret = new int[n][n];

        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		ret[j][n - i - 1] = matrix[i][j];
        	}
        }
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		matrix[i][j] = ret[i][j];
        	}
        }
        return;
    }
}

/*
*	in-place method
*/
public class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int i = 0; i < len / 2; i++) {
	        for(int j = i; j < len - i - 1; j++) {
	        	int tmp = matrix[i][j];
	        	matrix[i][j] = matrix[len - 1 - j][i];
	        	matrix[len - 1 - j][i] = matrix[len - 1 - i][len - 1 - j];
	        	matrix[len - 1 - i][len - 1 - j] = matrix[j][len - 1 - i];
	        	matrix[j][len - 1 - i] = tmp;
	        }
	    }
	    return;
    }
}