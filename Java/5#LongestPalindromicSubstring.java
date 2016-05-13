/**
*   method: dp
*/
public class Solution {
    public String longestPalindrome(String s) {
    	if(s.length() == 1)
    		return s;

    	int length = s.length();

    	int dp[][] = new int[length][length];

    	for(int i = 0; i < length; i++)
    		dp[i][i] = 1;

    	int startPos = 0;
    	int maxLength = 1;
    	for(int i = 1; i < length; i++) {
    		for(int j = 0; j + i < length; j++) {
    			if(s.charAt(j) == s.charAt(j + i)) {
    				if(i > 1) {
    					dp[j][j + i] = dp[j + 1][ j + i -1] + 2;
    				}
    				else {
    					dp[j][j + i] = 2;
    				}
    			}
    			else {
    				dp[j][j + i] = 0;
    			}

    			if(dp[j][j + i] > maxLength) {
    				startPos = j;
    				maxLength = dp[j][j + i];
    			}
    		}
    	}

    	String resultString = s.substring(startPos, startPos + maxLength);

    	return resultString;
    }
}

/*
*   method: center search
*/

public class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();

        if(length <= 1)
            return s;

        int start = 0, maxLen = 0;
        for(int i = 0; i < length; i++) {
            int low = i - 1, high = i;

            while(low >= 0 && high < length && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            }

            if(high - low - 1 > maxLen) {
                maxLen = high - low - 1;
                start = low + 1;
            }

            low = i - 1;
            high = i + 1;

            while(low >= 0 && high < length && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            }

            if(high - low - 1 > maxLen) {
                maxLen = high - low - 1;
                start = low + 1;
            }
        }

        return s.substring(start, start + maxLen);
    }
}

/*
*   Manacher
*/
public class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();

        if(length <= 1)
            return s;

        String str = preProcess(s);
        int n = str.length(), id = 0, mx = 0;
        int[] p = new int[n];

        for(int i = 1; i < n - 1; i++) {
            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
        
            while(str.charAt(i + p[i]) == str.charAt(i - p[i]))
               p[i]++;

            if(i + p[i] > mx) {
                mx = i + p[i];
                id = i;
            }
        }

        int maxLen = 0, index = 0;
        for(int i = 0; i < n - 1; i++) {
            if(p[i] > maxLen) {
                maxLen = p[i];
                index = i;
            }
        }

        return s.substring((index - maxLen) / 2, (index - maxLen) / 2 + maxLen - 1);
    }

    String preProcess(String s) {
        int n = s.length();

        StringBuffer sb = new StringBuffer();

        sb.append("$").append("#");

        for(int i = 0; i < n; i++) {
            sb.append(s.charAt(i)).append("#");
        }

        sb.append("^");

        String result = sb.toString();

        return result;
    }
}