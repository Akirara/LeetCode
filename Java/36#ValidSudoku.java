public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
        	int[] flag = new int[9];
        	for(int j = 0; j < 9; j++) {
        		char c = board[i][j];
        		if(c >= '1' && c <= '9') {
        			if(flag[c - '1'] == 1)
        				return false;
        			flag[c - '1'] = 1;
        		}
        	}
        }

        for(int i = 0; i < 9; i++) {
        	int[] flag = new int[9];
        	for(int j = 0; j < 9; j++) {
        		char c = board[j][i];
        		if(c >= '1' && c <= '9') {
        			if(flag[c - '1'] == 1)
        				return false;
        			flag[c - '1'] = 1;
        		}
        	}
        }

        int[] flag = new int[9];
        for(int i = 0; i < 3; i++) {
        	for(int j = 0; j < 3; j++) {
        		char c = board[i][j];
        		if(c >= '1' && c <= '9') {
        			if(flag[c - '1'] == 1)
        				return false;
        			flag[c - '1'] = 1;
        		}
        	}
        }

        flag = new int[9];
        for(int i = 0; i < 3; i++) {
        	for(int j = 3; j < 6; j++) {
        		char c = board[i][j];
        		if(c >= '1' && c <= '9') {
        			if(flag[c - '1'] == 1)
        				return false;
        			flag[c - '1'] = 1;
        		}
        	}
        }

        flag = new int[9];
        for(int i = 0; i < 3; i++) {
        	for(int j = 6; j < 9; j++) {
        		char c = board[i][j];
        		if(c >= '1' && c <= '9') {
        			if(flag[c - '1'] == 1)
        				return false;
        			flag[c - '1'] = 1;
        		}
        	}
        }

        flag = new int[9];
        for(int i = 3; i < 6; i++) {
        	for(int j = 0; j < 3; j++) {
        		char c = board[i][j];
        		if(c >= '1' && c <= '9') {
        			if(flag[c - '1'] == 1)
        				return false;
        			flag[c - '1'] = 1;
        		}
        	}
        }

        flag = new int[9];
        for(int i = 3; i < 6; i++) {
        	for(int j = 3; j < 6; j++) {
        		char c = board[i][j];
        		if(c >= '1' && c <= '9') {
        			if(flag[c - '1'] == 1)
        				return false;
        			flag[c - '1'] = 1;
        		}
        	}
        }

        flag = new int[9];
        for(int i = 3; i < 6; i++) {
        	for(int j = 6; j < 9; j++) {
        		char c = board[i][j];
        		if(c >= '1' && c <= '9') {
        			if(flag[c - '1'] == 1)
        				return false;
        			flag[c - '1'] = 1;
        		}
        	}
        }

        flag = new int[9];
        for(int i = 6; i < 9; i++) {
        	for(int j = 0; j < 3; j++) {
        		char c = board[i][j];
        		if(c >= '1' && c <= '9') {
        			if(flag[c - '1'] == 1)
        				return false;
        			flag[c - '1'] = 1;
        		}
        	}
        }

        flag = new int[9];
        for(int i = 6; i < 9; i++) {
        	for(int j = 3; j < 6; j++) {
        		char c = board[i][j];
        		if(c >= '1' && c <= '9') {
        			if(flag[c - '1'] == 1)
        				return false;
        			flag[c - '1'] = 1;
        		}
        	}
        }

        flag = new int[9];
        for(int i = 6; i < 9; i++) {
        	for(int j = 6; j < 9; j++) {
        		char c = board[i][j];
        		if(c >= '1' && c <= '9') {
        			if(flag[c - '1'] == 1)
        				return false;
        			flag[c - '1'] = 1;
        		}
        	}
        }

        return true;
    }
}