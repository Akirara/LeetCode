/**
*	use O(m+n) space
*/
public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(m == 0)
        	return;
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] col = new int[n];

        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(matrix[i][j] == 0) {
        			row[i] = 1;
        			col[j] = 1;
        		}
        	}
        }
        for(int i = 0; i < m; i++) {
        	if(row[i] == 1) {
        		for(int j = 0; j < n; j++) {
        			matrix[i][j] = 0;
        		}
        	}
        }
        for(int i = 0; i < n; i++) {
        	if(col[i] == 1) {
        		for(int j = 0; j < m; j++) {
        			matrix[j][i] = 0;
        		}
        	}
        }
        return;
    }
}

/**
*	use constant space
*/
public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(m == 0)
        	return;
        int n = matrix[0].length;
        boolean isRowZero = false;
        boolean isColZero = false;
        int i = 0, j = 0;
        for(i = 0; i < m; i++) {
        	if(matrix[i][0] == 0) {
        		isColZero = true;
        		break;
        	}
        }
        for(i = 0; i < n; i++) {
        	if(matrix[0][i] == 0) {
        		isRowZero = true;
        		break;
        	}
        }
        for(i = 0; i < m; i++) {
        	for(j = 0; j < n; j++) {
        		if(matrix[i][j] == 0) {
        			matrix[0][j] = 0;
        			matrix[i][0] = 0;
        		}
        	}
        }
        for(i = 1; i < m; i++) {
        	if(matrix[i][0] == 0) {
        		for(j = 1; j < n; j++) {
        			matrix[i][j] = 0;
        		}
        	}
        }
        for(i = 1; i < n; i++) {
        	if(matrix[0][i] == 0) {
        		for(j = 1; j < m; j++) {
        			matrix[j][i] = 0;
        		}
        	}
        }
        if(isRowZero) {
        	for(i = 0; i < n; i++) {
        		matrix[0][i] = 0;
        	}
        }
        if(isColZero) {
        	for(i = 0; i < m; i++) {
        		matrix[i][0] = 0;
        	}
        }
        return;
    }
}