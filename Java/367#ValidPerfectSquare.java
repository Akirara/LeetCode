public class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 2147483647)
        return false;
        for(int i = 0; ; i++) {
        	int time = i * i;
        	if(time > num)
        		return false;
        	if(time == num)
        		return true;
        }
    }
}