public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
    	if(z > x + y)
    		return false;
    	HashSet<Integer> hs = new HashSet();
    	Queue<Integer> q = new LinkedList();
    	hs.add(x);
    	hs.add(y);
    	hs.add(0);
    	if(hs.contains(z))
    		return true;
    	q.add(Math.abs(x - y));
    	while(q.peek() != null) {
    		int top = q.remove();
    		if(z == top || z == x + top || z == y + top)
    			return true;
    		hs.add(top);
    		if(!hs.contains(Math.abs(x - top))) {
    			q.add(Math.abs(x - top));
    		}
    		if(!hs.contains(Math.abs(y - top))) {
    			q.add(Math.abs(y - top));
    		}
    	}
    	return false;
    }
}

/**
*	math method
*/
public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        return z == 0 || (z <= x + y && z % gcd(x, y) == 0);
    }
    
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}