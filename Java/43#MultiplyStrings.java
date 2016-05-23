public class Solution {
    public String multiply(String num1, String num2) {
        String ret = new String();
        int len1 = num1.length();
        int len2 = num2.length();
        if(len1 == 0 || len2 == 0)
        	return ret;
        if(num1.charAt(0) == '0' || num2.charAt(0) == '0') {
        	ret = "0";
        	return ret;
        }

        int[] valOfNum1 = new int[len1];
        int[] valOfNum2 = new int[len2];
        int[] res = new int[len1 + len2];
        int i = 0, j = 0, k = len1 + len2 - 1;

        for(i = 0; i < len1; i++) {
        	valOfNum1[i] = num1.charAt(i) - '0';
        }
        for(i = 0; i < len2; i++) {
        	valOfNum2[i] = num2.charAt(i) - '0';
        }

        for(i = len1 - 1; i >= 0; i--, k--) {
        	for(j = len2 - 1; j >= 0; j--) {
        		int val = res[k + j + 1 - len2] + valOfNum1[i] * valOfNum2[j];
        		res[k + j - len2] += val / 10;
        		res[k + j + 1 - len2] = val % 10;
        	}
        }

        StringBuilder sb = new StringBuilder();
        for(i = 0; res[i] == 0; i++);
        for(; i < len1 + len2; i++) {
        	sb.append("" + res[i]);
        }
        ret = sb.toString();
        return ret;
    }
}