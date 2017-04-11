public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        for (List<Integer> l : wall) {
            int bricks = l.size() - 1;
            int width = 0;
            for (int i = 0; i < bricks; i++) {
                width += l.get(i);
                hm.put(width, hm.getOrDefault(width, 0) + 1);
            }
        }
        
        int height = wall.size();
        int ret = height;
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            ret = Math.min(ret, height - entry.getValue());
        }
        
        return ret;
    }
}