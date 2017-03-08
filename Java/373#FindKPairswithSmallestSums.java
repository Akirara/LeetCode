public class Solution {
    public class Tuple implements Comparable<Tuple> {
        int x, y, val;
        
        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        
        @Override
        public int compareTo(Tuple that) {
            return this.val - that.val;
        }
    }
    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        int len1 = nums1.length, len2 = nums2.length;
        List<int[]> res = new ArrayList<int[]>();
        
        if (len1 == 0 || len2 == 0 || k <= 0) {
            return res;
        }
        
        for (int i = 0; i < len2; i++) {
            pq.offer(new Tuple(0, i, nums1[0] + nums2[i]));
        }
        
        for (int i = 0; i < Math.min(k, len1 * len2); i++) {
            Tuple t = pq.poll();
            res.add(new int[]{nums1[t.x], nums2[t.y]});
            if (t.x < len1 - 1) {
                pq.offer(new Tuple(t.x + 1, t.y, nums1[t.x + 1] + nums2[t.y]));
            }
        }
        
        return res;
    }
}