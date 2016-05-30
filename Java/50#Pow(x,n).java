public class Solution {
    public double myPow(double x, int n) {
    	if(n == 0)
    		return 1;
    	int[] ntoBinary = new int[35];
    	int flag = 1;
    	long nLong = n;
    	if(n < 0) {
    		flag = 0;
    		nLong = -nLong;
    	}
    	int count = 0;
    	for(count = 1; nLong > 0; count++) {
    		ntoBinary[count] = nLong % 2;
    		nLong = nLong / 2;
    	}
    	double[] xPow2 = new double[count];
    	xPow2[0] = 1;
    	xPow2[1] = x; 
    	for(int i = 2; i < count; i++) {
    		xPow2[i] = xPow2[i - 1] * xPow2[i - 1];
    	}
    	double ret = 1;
    	for(int i = 0; i < count; i++) {
    		if(ntoBinary[i] == 1) {
    			ret = ret * xPow2[i];
    		}
    	}
    	if(flag	== 0) {
    		ret = 1 / ret;
    	}
    	return ret;
    }
}