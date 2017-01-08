public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        for (int h = len; h > 0; h--) {
            if (citations[len - h] >= h && (h == len || citations[len - h - 1] <= h)) {
                return h;
            }
        }
        return 0;
    }
}


public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] count = new int[len + 1];
        for (int citation : citations) {
            if (citation < len) {
                count[citation]++;
            } else {
                count[len]++;
            }
        }
        int ret = 0;
        for (int i = len; i >= 0; i--) {
            ret += count[i];
            if (ret >= i) {
                return i;
            }
        }
        return 0;
    }
}