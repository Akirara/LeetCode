public class Solution {
    public String simplifyPath(String path) {
        String[] split = path.split("/+");
        String[] list = new String[split.length];
        int pos = 0;
        for(int i = 1; i < split.length; i++) {
            if(split[i].equals("..")) {
                if(pos > 0) {
                    pos--;
                }
            }
            else if(split[i].equals(".")) {
                continue;
            }
            else {
                list[pos] = split[i];
                pos++;
            }
        }
        if(pos == 0) {
            return "/";
        }
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < pos; i++) {
            ret.append("/" + list[i]);
        }
        return ret.toString();
    }
}