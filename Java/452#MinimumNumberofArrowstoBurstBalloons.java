public class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                return a1[0] - a2[0];
            }
        });
        int len = points.length;
        if (len == 0) {
            return 0;
        }
        int right = points[0][1];
        int arrow = 1;
        for (int i = 1; i < len; i++) {
            if (points[i][0] > right) {
                arrow++;
                right = points[i][1];
            } else {
                right = Math.min(right, points[i][1]);
            }
        }
        return arrow;
    }
}