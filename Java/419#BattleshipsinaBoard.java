public class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        int x = board.length;
        int y = board[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] == '.')) {
                    count++;
                    while (j < y && board[i][j] == 'X') {
                        j++;
                    }
                }
            }
        }
        return count;
    }
}