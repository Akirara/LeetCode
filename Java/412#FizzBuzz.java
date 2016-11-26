public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> results = new ArrayList<String>();
        int count  = 1;
        for (int i = 1; i <= n; ++i, ++count) {
            if (count % 15 == 0) {
                results.add("FizzBuzz");
                count = 0;
            } else if (count % 3 == 0) {
                results.add("Fizz");
            } else if (count % 5 == 0) {
                results.add("Buzz");
            } else {
                results.add(String.valueOf(i));
            }
        }
        return results;
    }
}