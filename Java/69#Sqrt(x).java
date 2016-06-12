public class Solution {
    public int mySqrt(int x) {
        return binarySearch(x, 0, 46340);
    }
    public int binarySearch(int x, int low, int high) {
    	int middle = (low + high) / 2;
    	int mul = middle * middle;
    	long mulNext = (long)(middle + 1) * (middle + 1);
    	if(mul <= x && mulNext > x)
    		return middle;
    	if(mulNext <= x)
    		return binarySearch(x, middle + 1, high);  
    	return binarySearch(x, low, middle - 1);
    }
}