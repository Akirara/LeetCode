public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ret = new ArrayList();
        int len = s.length();
        HashSet<String> hs = new HashSet();
        for(int i = 0; i < len - 9; i++) {
        	String sub = s.substring(i, i + 10);
        	if(hs.contains(sub) && !ret.contains(sub))
        		ret.add(sub);
        	else
        		hs.add(sub);
        }
        return ret;
    }
}


public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ret = new ArrayList();
        int len = s.length();
        HashMap<String, Integer> hm = new HashMap();
        for(int i = 0; i < len - 9; i++) {
        	String sub = s.substring(i, i + 10);
        	if(hm.containsKey(sub)) {
        		int v = hm.get(sub);
        		if(v == 1) {
        			ret.add(sub);
        			hm.put(sub, 2);
        		}
        	}
        	else
        		hm.put(sub, 1);
        }
        return ret;
    }
}