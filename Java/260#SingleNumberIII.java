public class Solution {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> hs = new HashSet();

        for(int num : nums) {
        	if(hs.contains(num)) {
        		hs.remove(num);
        	}
        	else {
        		hs.add(num);
        	}
        }

        Integer[] tmp = hs.toArray(new Integer[]{});
        int[] ret = new int[2];
        ret[0] = tmp[0].intValue();
        ret[1] = tmp[1].intValue();

        return ret;
    }
}


public class Solution {
    public int[] singleNumber(int[] nums) {
        int tmp = 0;
        int[] ret = new int[2];
        
        for(int num : nums) {
        	tmp ^= num;
        }
        
        tmp &= -tmp;
        
        for(int num : nums) {
        	if((tmp & num) == 0) {
        		ret[0] ^= num;
        	}
        	else {
        		ret[1] ^= num;
        	}
        }

      	return ret;
    }
}