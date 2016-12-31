/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        int len = intervals.length;
        if (len < 2) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        int right = intervals[0].end;
        int count = 0;
        for (int i = 1; i < len; i++) {
            if (intervals[i].start < right) {
                count++;
                right = Math.min(right, intervals[i].end);
            } else {
                right = intervals[i].end;
            }
        }
        return count;
    }
}