public class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int low = 0;
        int high = ch.length - 1;
        while (low < high) {
            while (notVowel(ch[low]) && low < high) {
                low++;
            }
            while (notVowel(ch[high]) && low < high) {
                high--;
            }
            char tmp = ch[low];
            ch[low] = ch[high];
            ch[high] = tmp;
            low++;
            high--;
        }
        return String.valueOf(ch);
    }

    public boolean notVowel(char c) {
        switch (c) {
            case 'A' : case 'E': case 'I' : case 'O' : case 'U':
            case 'a' : case 'e': case 'i' : case 'o' : case 'u':
                return false;
            default :
                return true;
        }
    }
}