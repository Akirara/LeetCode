public class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        if(row == 0)
        	return;
        int col = board[0].length;
        for(int i = 0; i < col; i++) {
        	if(board[0][i] == 'O')
        		flood(board, row, col, 0, i);
        	if(board[row - 1][i] == 'O')
        		flood(board, row, col, row - 1, i);
        }
        for(int i = 0; i < row; i++) {
        	if(board[i][0] == 'O')
        		flood(board, row, col, i, 0);
        	if(board[i][col - 1] == 'O')
        		flood(board, row, col, i, col - 1);
        }
        for(int i = 0; i < row; i++) {
        	for(int j = 0; j < col; j++) {
        		if(board[i][j] == 'O')
        			board[i][j] = 'X';
        		else if(board[i][j] == 'T')
        			board[i][j] = 'O';
        	}
        }
        return;
    }

    public class Pos {
    	int x;
    	int y;
    	Pos(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }

    public void flood(char[][] board, int row, int col, int x, int y) {
    	Stack<Pos> stk = new Stack<Pos>();
    	Pos pos = new Pos(x, y);
    	stk.push(pos);
    	board[x][y] = 'T';
    	while(!stk.empty()) {
    		Pos top = stk.peek();
    		if(top.x > 0 && board[top.x - 1][top.y] == 'O') {
    			Pos left = new Pos(top.x - 1, top.y);
    			stk.push(left);
    			board[top.x - 1][top.y] = 'T';
    			continue;
    		}
    		if(top.x < row -1 && board[top.x + 1][top.y] == 'O') {
    			Pos right = new Pos(top.x + 1, top.y);
    			stk.push(right);
    			board[top.x + 1][top.y] = 'T';
    			continue;
    		}
    		if(top.y > 0 && board[top.x][top.y - 1] == 'O') {
    			Pos up = new Pos(top.x, top.y - 1);
    			stk.push(up);
    			board[top.x][top.y - 1] = 'T';
    			continue;
    		}
    		if(top.y < col - 1 && board[top.x][top.y + 1] == 'O') {
    			Pos down = new Pos(top.x, top.y + 1);
    			stk.push(down);
    			board[top.x][top.y + 1] = 'T';
    			continue;
    		}
    		stk.pop();
    	}
    }
}