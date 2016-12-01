public class Solution {
    public boolean isPowerOfFour(int num) {
        return ((num & (num - 1)) == 0) && (num % 3 == 1) && (num > 0); 
    }
}


public class Solution {
    public boolean isPowerOfFour(int num) {
        return Integer.toString(num, 4).matches("10*");
    }
}