public class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int tmp = 0;
        long com = num >= 0 ? num : (4294967296L + num);
        while (com > 0) {
            tmp = (int)(com % 16);
            if (tmp > 9) {
                sb.append((char)('a' + tmp - 10));
            } else {
                sb.append(tmp);
            }
            com /= 16;
        }
        return sb.reverse().toString();
    }
}



public class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
                      'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(map[num & 0x0f]);
            num = num >>> 4;
        }
        return sb.reverse().toString();
    }
}