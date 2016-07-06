public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n == 0)
        	return 0;
        int[] sum = new int[n];
        sum[0] = triangle.get(0).get(0);
        for(int i = 1; i < n; i++) {
        	int pre = sum[0];
        	List<Integer> row = triangle.get(i);
        	sum[0] += row.get(0);
        	for(int j = 1; j < i; j++) {
        		if(pre < sum[j]) {
        			int tmp = sum[j];
        			sum[j] = pre + row.get(j);
        			pre = tmp;
        		}
        		else {
        			pre = sum[j];
        			sum[j] += row.get(j);
        		}
        	}
        	sum[i] = pre + row.get(i);
        }
        int minSum = sum[0];
        for(int i = 1; i < n; i++) {
        	if(sum[i] < minSum)
        		minSum = sum[i];
        }
        return minSum;
    }
}