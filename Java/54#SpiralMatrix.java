public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<Integer>();
        int m = matrix.length;
        if(m == 0)
        	return ret;
        int n = matrix[0].length;
        int i = 0, j = 0;
        int halfM = m / 2;
        int halfN = n / 2;
        for(i = 0; i <= halfM && i <= halfN; i++) {
            int k = 2 * i;
        	for(j = i; k < m && j < n - i; j++)
        		ret.add(matrix[i][j]);
        	for(j = i + 1; k < n && j < m - i; j++)
        		ret.add(matrix[j][n - i - 1]);
        	for(j = n - i - 2; k + 1 < m && j >= i; j--)
        		ret.add(matrix[m - i - 1][j]);
        	for(j = m - i - 2; k + 1 < n && j > i; j--)
        		ret.add(matrix[j][i]);
        }
        return ret;
    }
}