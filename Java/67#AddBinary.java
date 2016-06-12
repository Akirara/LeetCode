public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sba = new StringBuilder(a);
        StringBuilder sbb = new StringBuilder(b);
        StringBuilder sum = new StringBuilder();
        sba.reverse();
        sbb.reverse();
        int lena = a.length();
        int lenb = b.length();
        int tmp = 0;
        int c = 0;
        for(int i = 0; i < lena || i < lenb; i++) {
        	tmp = c;
        	if(i < lena) {
        		tmp += sba.charAt(i) - '0';
        	}
        	if(i < lenb) {
        		tmp += sbb.charAt(i) - '0'; 
        	}
        	c = tmp / 2;
        	sum.append(tmp % 2);
        }
        if(c == 1) {
        	sum.append(c);
        }
        return sum.reverse().toString();
    }
}