public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if(row == 0)
        	return 0;
        int col = matrix[0].length;
        int[] sum = new int[col];
        int ret = 0;
        for(int i = 0; i < row; ++i) {
        	for(int j = 0; j < col; ++j) {
        		if(matrix[i][j] == '0')
        			sum[j] = 0;
        		else
        			++sum[j];
        	}
        	for(int j = 0; j < col; ++j) {
        		if(sum[j] == 0)
        			continue;
        		int tmp = sum[j];
        		int low = j, high = j;
        		while(low >= 0 && sum[low] >= tmp)
        			--low;
        		while(high < col && sum[high] >= tmp)
        			++high;
        		int area = tmp * (high - low - 1);
        		if(area > ret)
        			ret = area;
        	}
        }
        return ret;
    }
}


/**
*   improved method
*/
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if(row == 0)
            return 0;
        int col = matrix[0].length;
        int[] sum = new int[col];
        int ret = 0;
        Stack<Integer> sk = new Stack();
        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < col; ++j) {
                if(matrix[i][j] == '0')
                    sum[j] = 0;
                else
                    ++sum[j];
            }
            for(int j = 0; j < col; ++j) {
                while(!sk.empty() && sum[sk.peek()] >= sum[j]) {
                    int area = sum[sk.pop()] * (sk.empty() ? j : j - sk.peek() - 1);
                    if(area > ret)
                        ret = area;
                }
                sk.push(j);
            }
            while(!sk.empty()) {
                int area = sum[sk.pop()] * (sk.empty() ? col : col - sk.peek() - 1);
                if (area > ret)
                    ret = area;
            }
        }
        return ret;
    }
}