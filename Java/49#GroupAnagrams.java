/*
*	hash method
*/
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        int len = strs.length;
        for(int i = 0; i < len; i++) {
        	char[] chars = strs[i].toCharArray();
        	Arrays.sort(chars);
        	String s = new String(chars);
        	List<String> list = new ArrayList<String>();
        	if(map.containsKey(s)) {
        		list = map.get(s);
        	}
    		list.add(strs[i]);
        	map.put(s, list);
        }

        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()) {
        	Map.Entry entry = (Map.Entry)iter.next();
        	List<String> list = (List<String>)entry.getValue();
        	Collections.sort(list);
        	ret.add(list);
        }
        return ret;
    }
}