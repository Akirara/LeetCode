public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0)
        	return false;
        int n = matrix[0].length;
        if(matrix[0][0] > target || matrix[m - 1][n - 1] < target)
        	return false;
        int row = searchRow(matrix, target, 0, m - 1);
        return searchCol(matrix, target, row, 0, n - 1);
    }

    public int searchRow(int[][] matrix, int target, int low, int high) {
    	if(low == high)
    		return low;
    	int middle = (low + high) / 2;
    	int rowValue = matrix[middle][0];
    	int nextRowValue = matrix[middle + 1][0];
    	if(rowValue <= target && nextRowValue > target)
    		return middle;
    	if(rowValue > target)
    		return searchRow(matrix, target, low, middle - 1);
    	return searchRow(matrix, target, middle + 1, high);
    }

    public boolean searchCol(int[][] matrix, int target, int row, int low, int high) {
    	if(low > high)
    		return false;
    	int middle = (low + high) / 2;
    	if(matrix[row][middle] == target)
    		return true;
    	if(matrix[row][middle] > target)
    		return searchCol(matrix, target, row, low, middle - 1);
    	return searchCol(matrix, target, row, middle + 1, high);
    }

}