public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int[] rank = nums.clone();
        Arrays.sort(rank);
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        String[] relativeRank = new String[len];
        for (int i = 0; i < len; i++) {
            low = 0;
            high = len - 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (rank[mid] >= nums[i]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            low = len - low;
            if (low < 4) {
                if (low == 1) {
                    relativeRank[i] = "Gold Medal";
                } else if (low == 2) {
                    relativeRank[i] = "Silver Medal";
                } else {
                    relativeRank[i] = "Bronze Medal";
                }
            } else {
                relativeRank[i] = String.valueOf(low);
            }
        }
        return relativeRank;
    }
}


public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        Integer[] index = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));
        String[] result = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[index[i]] = "Gold Medal";
            } else if (i == 1) {
                result[index[i]] = "Silver Medal";
            } else if (i == 2) {
                result[index[i]] = "Bronze Medal";
            } else {
                result[index[i]] = (i + 1) + "";
            }
        }
        return result;
    }
}