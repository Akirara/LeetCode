public class Solution {
	public static String minWindow(String s, String t) {
	    int[] tCount = new int[128];
	    int[] sCount = new int[128];
	    int count = 0;
	    for(int i = 0; i < t.length(); ++i) {
	        ++tCount[t.charAt(i)];
	        ++count;
	    }
	    String window = new String();
	    for(int l = 0, r = 0; r < s.length(); ) {
	        for(; r < s.length(); ++r) {
	            if(tCount[s.charAt(r)] > 0) {
	                ++sCount[s.charAt(r)];
	                if(sCount[s.charAt(r)] <= tCount[s.charAt(r)]) {
	                    --count;
	                    if(count == 0) {
	                        ++r;
	                        break;
	                    }
	                }
	                else {
	                    ++r;
	                    break;
	                }
	            }
	        }
	        for(; l < r; ++l) {
	            if(tCount[s.charAt(l)] > 0) {
	                if(sCount[s.charAt(l)] > tCount[s.charAt(l)]) {
	                    --sCount[s.charAt(l)];
	                }
	                else {
	                    break;
	                }
	            }
	        }
	        if(count == 0 && (window.length() == 0 || r - l < window.length())) {
	            window = s.substring(l, r);
	        }
	    }
	    return window;
	}
}