public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder s = new StringBuilder();
        s.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        s.append(num / den);
        num %= den;
        if (num == 0) {
            return s.toString();
        }
        s.append(".");
        HashMap<Long, Integer> hm = new HashMap<>();
        hm.put(num, s.length());
        while (num != 0) {
            num *= 10;
            s.append(num / den);
            num %= den;
            if (hm.containsKey(num)) {
                s.insert(hm.get(num), "(");
                s.append(")");
                break;
            } else {
                hm.put(num, s.length());
            }
        }
        return s.toString();
    }
}