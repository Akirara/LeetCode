public class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0)
        	return 0;
        int ret = 0;
        Stack<Integer> sk = new Stack();
        for (int i = 0; i < len; ++i) {
        	while (!sk.empty() && heights[sk.peek()] >= heights[i]) {
        		int area = heights[sk.pop()] * (sk.empty() ? i : i - sk.peek() - 1);
        		if (area > ret)
        			ret = area;
        	}
        	sk.push(i);
        }
        while (!sk.empty()) {
        	int area = heights[sk.pop()] * (sk.empty() ? len : len - sk.peek() - 1);
        	if (area > ret)
        		ret = area;
        }
        return ret;
    }
}


/**
*	TLE
*/
public class Solution {
    public int largestRectangleArea(int[] heights) {
		int len = heights.length;
		if(len == 0)
			return 0;
		int ret = 0;
		for(int i = 0; i < len; ++i) {
			int low = i;
			int high = i;
			while(low >= 0 && heights[low] >= heights[i])
				low--;
			while(high < len && heights[high] >= heights[i])
				high++;
			int area = heights[i] * (high - low -1);
			if(area > ret)
				ret = area;
		}       
		return ret;
    }
}