public class Solution {
    static List<String>[] hour = new List[4];
    static List<String>[] minute = new List[6];
    static {
        hour[0] = new ArrayList<>();
        hour[0].add("0");
        for (int i = 1; i < 12; i++) {
            int k = 0, temp = i;
            while (temp != 0) {
                temp = temp & (temp-1);
                k++;
            }
            if (hour[k] == null) {
                hour[k] = new ArrayList<>();
            }
            hour[k].add("" + i);
        }
        minute[0] = new ArrayList<>();
        minute[0].add("00");
        for (int i = 1; i < 60; i++) {
            int k = 0, temp = i;
            while (temp != 0) {
                temp = temp & (temp-1);
                k++;
            }
            if (minute[k] == null) {
                minute[k] = new ArrayList<>();
            }

            if (i < 10) {
                minute[k].add("0" + i);
            } else {
                minute[k].add("" + i);
            }
        }
    }

    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i <= num && i < 4 ; i++) {
            if (num - i >= 6) continue;
            List<String> h = hour[i];
            List<String> m = minute[num - i];
            for (String strH : h) {
                for (String strM : m) {
                    res.add(strH + ":" + strM);
                }
            }
        }
        return res;
    }
}