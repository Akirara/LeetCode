/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if(node == null) {
    		return null;
    	}

    	HashMap<Integer, UndirectedGraphNode> hm = new HashMap<>();
		Queue<UndirectedGraphNode> source = new LinkedList<>();
		Queue<UndirectedGraphNode> target = new LinkedList<>();
		UndirectedGraphNode ret = new UndirectedGraphNode(node.label);
		source.add(node);
		target.add(ret);
		hm.put(ret.label, ret);

		UndirectedGraphNode first1;
		UndirectedGraphNode first2;
		while((first1 = source.poll()) != null) {
			first2 = target.poll();
			for(int i = 0; i < first1.neighbors.size(); ++i) {
				int key = first1.neighbors.get(i).label;
				if(hm.containsKey(key)) {
					first2.neighbors.add(hm.get(key));
				}
				else {
					UndirectedGraphNode tmp = new UndirectedGraphNode(key);
					first2.neighbors.add(tmp);
					hm.put(key, tmp);

					if(first1.label != key) {
						source.add(first1.neighbors.get(i));
						target.add(first2.neighbors.get(i));
					}
				}
			}
		}

		return ret;
    }
}