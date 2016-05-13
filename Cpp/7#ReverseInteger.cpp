class Solution {
public:
    int reverse(int x) {
  		int ret = 0;
  		bool isNegative = x < 0 ? true : false;

  		if(isNegative)
  			x = -x;

  		while(x > 0) {
  			if(ret > INT_MAX / 10)
  				return 0;

  			ret = ret * 10 + x % 10;
  			x = x / 10;
  		}

  		if(isNegative)
  			ret = -ret;

  		return ret;
    }
};