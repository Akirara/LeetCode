public class Solution {
    public String countAndSay(int n) {
        String s = new String();
        if(n < 1)
        	return s;
        s = "1";
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        int i, j;
        int len;
        int count;
        StringBuilder tmp;
        for(i = 1; i < n; i++) {
        	len = sb.length();
        	count = 1;
        	tmp = new StringBuilder();
        	for(j = 0; j < len; j++) {
        		if(j < len - 1 && sb.charAt(j) == sb.charAt(j + 1)) {
        			count++;
        		}
        		else {
        			tmp = tmp.append("" + count + sb.charAt(j));
        			count = 1;
        		}
        	}
        	sb = tmp;
        }
        s = sb.toString();
        return s;
    }
}