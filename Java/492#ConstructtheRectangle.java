public class Solution {
    public int[] constructRectangle(int area) {
        int[] ret = new int[2];
        
        int w = (int)Math.sqrt(area);
        
        while (area % w != 0) {
            w--;
        }
        
        ret[0] = area / w;
        ret[1] = w;
        
        return ret;
    }
}