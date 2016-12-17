public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
               return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1];  
            }
        });
        List<int[]> l = new LinkedList<>();
        for (int[] person : people) {
            l.add(person[1], person);
        }
        return l.toArray(new int[people.length][]);
    }
}