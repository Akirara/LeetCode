public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
        	int a = n % 26 - 1;
        	sb.append(a == -1 ? 'Z' : (char)('A' + a));
        	n /= 26;
        	if(a == -1)
        		--n;
        }
        return sb.reverse().toString();
    }
}