public class Solution {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> hm = new HashMap<>();
        char[] ch = s.toCharArray();

        for(int i = 0; i < ch.length; ++i) {
            if(hm.containsKey(ch[i])) {
                hm.put(ch[i], hm.get(ch[i]) + 1);
            }
            else {
                hm.put(ch[i], 1);
            }
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if(o1.getValue() < o2.getValue()) {
                    return 1;
                }
                else {
                    return -1;
                }
            }
        });

        for(int i = 0; i < list.size(); ++i) {
            Map.Entry entry = list.get(i);
            char key = (Character) entry.getKey();
            int value = (Integer) entry.getValue();
            for(int j = 0; j < value; ++j) {
                sb.append(key);
            }
        }

        return sb.toString();
    }
}


public class Solution {
	public class item {
        char ch;
        int count;
        public item(char c) {
            ch = c;
            count = 0;
        }
    }

    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        item[] record = new item[62];

        for(int i = 0; i < 26; ++i) {
            record[i] = new item((char)('a' + i));
        }

        for(int i = 26; i < 52; ++i) {
            record[i] = new item((char)('A' + i - 26));
        }

        for(int i = 52; i < 62; ++i) {
            record[i] = new item((char)(i - 52));
        }

        char[] ch = s.toCharArray();

        for(int i = 0; i < ch.length; ++i) {
            if(ch[i] >= 'a' && ch[i] <= 'z') {
                ++record[ch[i] - 'a'].count;
            }
            else if(ch[i] >= 'A' && ch[i] <= 'Z'){
                ++record[ch[i] - 'A' + 26].count;
            }
            else if(ch[i] >= '0' && ch[i] <= '9') {
            	++record[ch[i] - '0' + 52].count;
            }
        }

        Arrays.sort(record, new Comparator<item>() {
            @Override
            public int compare(item o1, item o2) {
                if(o1.count < o2.count) {
                    return 1;
                }
                else {
                    return -1;
                }
            }
        });

        for(int i = 0; i < 52; ++i) {
            for(int j = 0; j < record[i].count; ++j) {
                sb.append(record[i].ch);
            }
        }

        return sb.toString();
    }
}