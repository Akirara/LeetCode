/*
*	ugly
*/
public class Solution {
    public String intToRoman(int num) {
    	int[] count = {0, 0, 0, 0};
    	int i = 0;

    	count[0] = num / 1000;
    	num = num % 1000;
    	
    	count[1] = num / 100;
    	num = num % 100;
    	
    	count[2] = num / 10;
    	
    	count[3] = num % 10;

    	String s = new String();

    	for(i = 0; i < count[0]; i++)
    		s += "M";

    	switch(count[1]) {
    		case 1:
    			s += "C";
    			break;
    		case 2:
    			s += "CC";
    			break;
    		case 3:
    			s += "CCC";
    			break;
    		case 4:
    			s += "CD";
    			break;
    		case 5:
    			s += "D";
    			break;
    		case 6:
    			s += "DC";
    			break;
    		case 7:
    			s += "DCC";
    			break;
    		case 8:
    			s += "DCCC";
    			break;
    		case 9:
    			s += "CM";
    			break;
    		default:
    			break;
    	}
    	
    	switch(count[2]) {
    		case 1:
    			s += "X";
    			break;
    		case 2:
    			s += "XX";
    			break;
    		case 3:
    			s += "XXX";
    			break;
    		case 4:
    			s += "XL";
    			break;
    		case 5:
    			s += "L";
    			break;
    		case 6:
    			s += "LX";
    			break;
    		case 7:
    			s += "LXX";
    			break;
    		case 8:
    			s += "LXXX";
    			break;
    		case 9:
    			s += "XC";
    			break;
    		default:
    			break;
    	}

    	switch(count[3]) {
    		case 1:
    			s += "I";
    			break;
    		case 2:
    			s += "II";
    			break;
    		case 3:
    			s += "III";
    			break;
    		case 4:
    			s += "IV";
    			break;
    		case 5:
    			s += "V";
    			break;
    		case 6:
    			s += "VI";
    			break;
    		case 7:
    			s += "VII";
    			break;
    		case 8:
    			s += "VIII";
    			break;
    		case 9:
    			s += "IX";
    			break;
    		default:
    			break;
    	}

    	return s;
    }
}

/*
*
*/
public class Solution {
    public String intToRoman(int num) {
        String[] s = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",
    					"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC",
    					"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM",
    					"", "M", "MM", "MMM"};

    	String ret = new String();
    	int index = 0;
    	while(num > 0) {
    		ret = s[index + num % 10] + ret;
    		num /= 10;
    		index += 10;
    	}

    	return ret;
    }
}