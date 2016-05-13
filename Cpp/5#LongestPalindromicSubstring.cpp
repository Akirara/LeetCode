class Solution {
public:
    string longestPalindrome(string s) {
        if(s.size() == 1)
    		return s;

    	int length = s.size();

    	vector<vector<int>> dp(2,vector<int>(length));

    	int startPos = 0;
    	int maxLength = 1;
        int now = 0;
    	for(int i = length - 1; i >= 0; i--) {
            dp[now][i] = 1;

    		for(int j = i + 1; j < length; j++) {
    			if(s[i] == s[j]) {
    				if(j - i > 1) {
                        if(dp[1 - now][j - 1] > 0) {
    					   dp[now][j] = dp[1 - now][j - 1] + 2;
                        }
                        else {
                            dp[now][j] = 0;
                        }
    				}
    				else {
    					dp[now][j] = 2;
    				}
    			}
    			else {
    				dp[now][j] = 0;
    			}

    			if(dp[now][j] > maxLength) {
    				startPos = i;
    				maxLength = dp[now][j];
    			}
    		}

            now = 1 - now;
    	}

    	string resultString = s.substr(startPos, maxLength);

    	return resultString;
    }
};