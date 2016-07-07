/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return binary(1, n);
    }

    public int binary(int low, int high) {
    	if(low == high)
    		return low;
    	int middle = (int)(((long)low + (long)high) / 2);
    	if(isBadVersion(middle))
    		return binary(low, middle);
    	return binary(middle + 1, high);
    }
}