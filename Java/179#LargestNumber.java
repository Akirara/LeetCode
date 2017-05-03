public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        
        ArrayList<String> array = new ArrayList<>();
        for (int n : nums) {
            array.add(String.valueOf(n));
        }
        
        Collections.sort(array, new Comparator<String>() {
            public int compare(String s1, String s2) {
                String s = s2 + s1;
                String ss = s1 + s2;
                return s.compareTo(ss);
                
            }});
            
        if (array.get(0).charAt(0) == '0') {
            return "0";
        }
        
        StringBuilder sbuilder = new StringBuilder();
        
        for (String s : array) {
            sbuilder.append(s);
        }
        
        return sbuilder.toString();
    }
}