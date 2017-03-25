public class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }

        char[] tmp = new char[15];
        int abs = Math.abs(num);
        int i = 14;

        while (abs > 0) {
            tmp[i] = (char)('0' + (abs % 7));
            abs = abs / 7;
            i--;
        }

        if (num < 0) {
            tmp[i] = '-';
            i--;
        }
        
        return new String(tmp, i + 1, 14 - i);
    }
}