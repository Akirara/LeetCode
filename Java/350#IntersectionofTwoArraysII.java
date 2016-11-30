public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ret = new int[Math.min(len1, len2)];
        int count = 0;
        for (int i = 0, j = 0; i < len1 && j < len2; ) {
            if (nums1[i] == nums2[j]) {
                ret[count++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOf(ret, count);
    }
}