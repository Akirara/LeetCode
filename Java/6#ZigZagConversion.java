public class Solution {
    public String convert(String s, int numRows) {
 		String[] line = new String[numRows];
 		int dir = 0;

  		for(int i = 0, j = 0; i < s.length(); i++) {
 			line[j] = line[j] + s.charAt(i);
 			((dir == 0)?(j++):(j--);
 			if(j == 0 || j == (numRows - 1)) {
 				dir = 1- dir;
 			}
 		}
 		String result;
 		for(int i = 0; i < numRows; i++) {
 			result = result + line[i];
 		}
 		return result;
    }
}