public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int len = nums.length;
        int[] res = new int[len - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        
        for (int i = k, j = 0; i < len; i++, j++) {
            res[j] = nums[dq.peekFirst()];
            
            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.pollLast();
            }
            
            dq.offerLast(i);
            
            if (dq.peekFirst() == j) {
                dq.pollFirst();
            }
        }
        
        res[len - k] = nums[dq.peekFirst()];
        
        return res;
    }
}