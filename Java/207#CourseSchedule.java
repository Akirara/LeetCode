public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	int[] inDeg = new int[numCourses];
    	List<List<Integer>> pre = new ArrayList<List<Integer>>();
    	for(int i = 0; i < numCourses; ++i) {
    		List<Integer> l = new ArrayList<Integer>();
    		pre.add(l);
    	}
    	for(int i = 0; i < prerequisites.length; ++i) {
    		++inDeg[prerequisites[i][1]];
    		pre.get(prerequisites[i][0]).add(prerequisites[i][1]);
    	}
    	Queue<Integer> zeroDegNodeQueue = new LinkedList<Integer>();
    	for(int i = 0; i < numCourses; ++i) {
    		if(inDeg[i] == 0)
    			zeroDegNodeQueue.offer(i);
    	}
    	int count = zeroDegNodeQueue.size();
    	while(!zeroDegNodeQueue.isEmpty()) {
    		int top = zeroDegNodeQueue.poll();
    		List<Integer> l = pre.get(top);
    		for(int i = 0; i < l.size(); ++i) {
    			if(--inDeg[l.get(i)] == 0) {
    				zeroDegNodeQueue.offer(l.get(i));
    				++count;
    			}
    		}
    	}
    	return count == numCourses;
    }
}