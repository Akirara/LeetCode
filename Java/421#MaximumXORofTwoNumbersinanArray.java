public class Solution {
    public int findMaximumXOR(int[] nums) {
 		int max = 0, mask = 0;
 		for(int i = 31; i >= 0; --i) {
 			mask = mask | (1 << i);
 			HashSet<Integer> hs = new HashSet();
 			
 			for(int num : nums) {
 				hs.add(num & mask);
 			}
 			int tmp = max | (1 << i);

 			for(int num : hs) {
 				if(hs.contains(num ^ tmp)) {
 					max = tmp;
 					break;
 				}
 			}
 		}

 		return max;
    }
}