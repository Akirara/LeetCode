public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int radius =  0;
        int pos = 0;
        int len1 = houses.length;
        int len2 = heaters.length;
        for (int i = 0; i < len1; i++) {
            while (pos < len2 && houses[i] > heaters[pos]) {
                pos++;
            }
            if (pos == len2) {
                return Math.max(radius, houses[len1 - 1] - heaters[len2 - 1]);
            } else if (pos > 0) {
                radius = Math.max(Math.min(houses[i] - heaters[pos - 1], heaters[pos] - houses[i]), radius);
            } else {
                radius = Math.max(radius, heaters[pos] - houses[i]);
            }
        }
        return radius;
    }
}