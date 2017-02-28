public class Solution {
    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        for (String s : words) {
            if (s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")) {
                res.add(s);
            }
        }
        String[] ret = (String[]) res.toArray(new String[res.size()]);
        return ret;
    }
}