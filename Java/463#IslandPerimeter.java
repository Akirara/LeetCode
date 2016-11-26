public class Solution {
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        int row = grid.length;
        if (row == 0) {
            return result;
        }
        int col = grid[0].length;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) {
                        ++result; 
                    }
                    if (i == row - 1 || grid[i + 1][j] == 0) {
                        ++result;
                    }
                    if (j == 0 || grid[i][j - 1] == 0) {
                        ++result;
                    }
                    if (j == col - 1 || grid[i][j + 1] == 0) {
                        ++result;
                    }
                }
            }
        }
        return result;
    }
}