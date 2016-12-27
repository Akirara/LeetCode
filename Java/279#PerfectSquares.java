public class Solution {
    public int numSquares(int n) {
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n) {
            return 1;
        }
        while ((n & 3) == 0) {
            n >>= 2;  
        }
        if ((n & 7) == 7) {
            return 4;
        }
        for (int i = 1; i <= sqrt; i++) {
            int tmp = n - i * i;
            int sqrtTmp = (int) Math.sqrt(tmp);
            if (sqrtTmp * sqrtTmp == tmp) {
                return 2;
            }
        }
        return 3;
    }
}


public class Solution {
    public int numSquares(int n) {
        int[] ret = new int[n + 1];
        int[] square = new int[n + 1];
        int len = 1;
        int tmp = 1;
        while (tmp <= n) {
            ret[tmp] = 1;
            square[len - 1] = tmp;
            len++;
            tmp = len * len;
        }
        len--;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < len; j++) {
                tmp = i + square[j];
                if (tmp > n) {
                    break;
                } else if (ret[tmp] == 0 || ret[i] + 1 < ret[tmp]) {
                    ret[tmp] = ret[i] + 1;
                }
            }
        }
        return ret[n];
    }
}


public class Solution {
    public static List<Integer> l = new ArrayList<Integer>(Arrays.asList(0));

    public int numSquares(int n) {
        int len = l.size();
        int min = Integer.MAX_VALUE;
        while (len <= n) {
            min = Integer.MAX_VALUE;
            for (int i = 1; i * i <= len; i++) {
                min = Math.min(min, l.get(len - i * i) + 1);
            }
            l.add(min);
            len++;
        }
        return l.get(n);
    }
}