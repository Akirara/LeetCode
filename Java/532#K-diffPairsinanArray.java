//use hashmap
public class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k < 0) {
            return 0;
        }
        
        Map<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        
        for (int n : nums) {
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (k == 0) {
                if (entry.getValue() > 1) {
                    count++;
                }
            } else {
                if (hm.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        
        return count;
    }
}

// two pointers
public class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int dif = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                dif = nums[j] - nums[i];
                if (dif == k) {
                    count++;
                    break;
                } else if (dif > k) {
                    break;
                }
            }
            
            while (i < nums.length - 1 && nums[i + 1] == nums[i]) {
                i++;
            }
        }
        
        return count;
    }
}