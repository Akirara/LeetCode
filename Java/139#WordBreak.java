public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
    	int len = s.length();
    	if(len == 0)
    		return true;
    	boolean[] pos = new boolean[len];
    	for(int i = 0; i < len; i++) {
    		pos[i] = false;
    		String subStr = s.substring(0, i + 1);
    		if(wordDict.contains(subStr)) {
    			pos[i] = true;
    			continue;
    		}
    		for(int j = i - 1; j >= 0; j--) {
    			if(pos[j]) {
    				subStr = s.substring(j + 1, i + 1);
    				if(wordDict.contains(subStr)) {
    					pos[i] = true;
    					break;
    				}
    			}
    		}
    	}
    	return pos[len - 1];
    }
}