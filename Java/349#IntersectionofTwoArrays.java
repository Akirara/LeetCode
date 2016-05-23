public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ret = new int[0];
        if(len1 == 0 || len2 == 0)
        	return ret;

        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i = 0, j = 0; i < len1 && j < len2;) {
        	int val1 = nums1[i];
        	int val2 = nums2[j];
        	if(val1 == val2) {
        		if(list.size() == 0 || list.get(list.size() - 1) != val1)
        			list.add(val1);
        		i++;
        		j++;
        	}
        	else if(val1 < val2) {
        		i++;
        	}
        	else {
        		j++;
        	}
        }
        int len = list.size();
        ret = new int[len];
        for(int i = 0; i < len; i++) {
        	ret[i] = list.get(i);
        }
        return ret;
    }
}