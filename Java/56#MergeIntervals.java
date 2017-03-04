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
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        List<Interval> ret = new ArrayList<Interval>();
        intervals.sort((Interval i1, Interval i2) -> (i1.start - i2.start));
        int left = intervals.get(0).start, right = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start <= right) {
                right = Math.max(right, interval.end);
            } else {
                ret.add(new Interval(left, right));
                left = interval.start;
                right = interval.end;
            }
        }
        ret.add(new Interval(left, right));
        return ret;
    }
}