/*
*	low efficiency
*/
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<String>();

        if(n == 0)
        	return l;

        String s = "()";
        l.add(s);

        while(n > 1) {
        	List<String> tmp = new ArrayList<String>();

        	for(int i = 0; i < l.size(); i++) {
        		s = l.get(i);
        		for(int j = 0; j < s.length(); j++) {
        			String subStr = s.substring(0, j) + "()" + s.substring(j, s.length());
        			if(!tmp.contains(subStr))
        				tmp.add(subStr);
        		}
        	}

        	l.clear();
        	l.addAll(tmp);
        	n--;
        }
        return l;
    }
}

/*
*
*/
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<String>();

        if(n == 0)
        	return l;

        String s = new String();
        generate(l, s, n, n);

        return l;
    }

    public void generate(List<String> list, String s, int l, int r) {
    	if(l < 0 || r < 0)
    		return;
    	if(l == 0 && r == 0) {
    		list.add(s);
    		return;
    	}

    	if(l > 0)
    		generate(list, s + "(" , l - 1, r);
    	if(l < r)
    		generate(list, s + ")", l, r - 1);
    }
}