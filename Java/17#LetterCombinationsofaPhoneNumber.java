public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();

        if(digits.length() < 1)
            return list;
        
        List<String> tmp = new ArrayList<String>();
        List<String> digit = new ArrayList(){{add("abc"); add("def"); add("ghi"); add("jkl"); add("mno"); add("pqrs"); add("tuv"); add("wxyz");}};

        int index = digits.charAt(0) - '2';
        String s = digit.get(index);
        int i = 0, j = 0, k = 0, lenOfString = 0;
        char c;

        for(i = 0; i < s.length(); i++) {
            list.add(String.valueOf(s.charAt(i)));
        }

        int len = digits.length();
        for(i = 1; i < len; i++) {
            index = digits.charAt(i) - '2';
            s = digit.get(index);
            lenOfString = s.length();
            
            for(j = 0; j < lenOfString; j++) {
                c = s.charAt(j);
                for(k = 0; k < list.size(); k++) {
                    tmp.add(list.get(k) + c);
                }
            }

            list.clear();
            list.addAll(tmp);
            tmp.clear();
        }

        return list;
    }
}