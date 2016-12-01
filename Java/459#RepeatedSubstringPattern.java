public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        int len = str.length();
    	for (int i = len/2; i >= 1; i--) {
    		if (len % i == 0) {
    			int m = len / i;
    			String subS = str.substring(0, i);
    			int j;
    			for (j = 1; j < m; j++) {
    				if (!subS.equals(str.substring(j * i, i + j * i))) {
                        break;
                    }
    			}
    			if (j == m) {
    			    return true;
                }
    		}
    	}
    	return false;
    }
}



public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        int[] prefix = kmp(str);
        int len = prefix[str.length() - 1];
        int n = str.length();
        return (len > 0 && n % (n - len) == 0);
    }

    private int[] kmp(String s){
        int len = s.length();
        int[] res = new int[len];
        char[] ch = s.toCharArray();
        int i = 0, j = 1;
        res[0] = 0;
        while (i < ch.length && j < ch.length) {
            if (ch[j] == ch[i]) {
                res[j] = i + 1;
                i++;
                j++;
            } else {
                if (i == 0) {
                    res[j] = 0;
                    j++;
                } else {
                    i = res[i - 1];
                }
            }
        }
        return res;
    }
}