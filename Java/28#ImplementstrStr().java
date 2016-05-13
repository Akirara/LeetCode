public class Solution {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if(len2 == 0)
        	return 0;
        if(len1 < len2)
        	return -1;
        int i = 0, j = 0;
        for(i = 0; i <= len1 - len2; i++) {
        	for(j = 0; j < len2; j++) {
        		if(haystack.charAt(i + j) != needle.charAt(j)) {
        			break;
        		}
        	}
        	if(j == len2)
        		return i;
        }
        return -1;
    }
}

/*
*	Trie Tree
*/
