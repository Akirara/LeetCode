/**
*	one-pass
*/
public class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if(len == 0)
        	return;
        int posOf1 = -1;
        int posOf2 = -1;
        for(int i = 0; i < len; i++) {
        	switch(nums[i]) {
        		case 0:
        			//之前有1
        			if(posOf1 != -1) {
        				swap(nums, posOf1, i);//交换0和1
        				//之前有2
        				if(posOf2 != -1) {
        					swap(nums, i, posOf2);//交换1和2
        					if(nums[++posOf1] != 1) {
        						posOf1 = posOf2;
        					}
        					if(nums[++posOf2] != 2) {
        						posOf2 = i;
        					}
        				}
        				//之前没有2
        				else {
        					if(nums[++posOf1] != 1) {
        						posOf1 = i;
        					}
        				}
        			}
        			//之前没有1,但是有2
        			else if(posOf2 != -1){
        				swap(nums, posOf2, i);
        				if(nums[++posOf2] != 2) {
        					posOf2 = i;
        				}
        			}
        			break;
        		case 1:
        			//之前有2
        			if(posOf2 != -1) {
        				swap(nums, i, posOf2);//交换1和2
        				if(posOf1 == -1) {
        					posOf1 = posOf2;
        				}
        				if(nums[++posOf2] != 2) {
        					posOf2 = i;
        				}
        			}
        			if(posOf1 == -1) {
        				posOf1 = i;
        			}
        			break;
        		case 2:
        			if(posOf2 == -1) {
        				posOf2 = i;
        			}
        			break;
        		default:
        			break;
        	}
        }
        return;
    }

    public void swap(int[] nums, int i, int j) {
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    	return;
    }
}

/**
*	two-pass
*/
public class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if(len == 0)
        	return;
        int[] count = new int[3];
        int i = 0;
        for(i = 0; i < len; i++)
        	count[nums[i]]++;
        for(i = 0; i < count[0]; i++)
        	nums[i] = 0;
        for(i = count[0]; i < count[0] + count[1]; i++)
        	nums[i] = 1;
        for (i = count[0] + count[1]; i < len; i++)
        	nums[i] = 2;
        return;
    }
}