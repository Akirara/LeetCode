public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> q = new LinkedList();
        q.add(beginWord);
        HashSet<String> tmp = new HashSet();
        tmp.addAll(wordList);
        int distance = 1;
        while(!q.isEmpty()) {
        	int count = q.size();
        	while(count > 0) {
	        	char[] ch =q.remove().toCharArray();
	        	int len = ch.length;
	        	for(int i = 0; i < len; ++i) {
	        		char cTmp = ch[i];
	        		for(char c = 'a'; c <= 'z'; ++c) {
	        			if(c == cTmp)
	        				continue;
	        			ch[i] = c;
	        			String s = String.valueOf(ch);
	        			if(s.equals(endWord))
	        				return distance + 1;
	        			if(tmp.contains(s)) {
	        				q.add(s);
	        				tmp.remove(s);
	        			}

	        		}
	        		ch[i] = cTmp;
	        	}
	        	--count;
	        }
        	++distance;
        }
        return 0;
    }
}



public class Solution {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

		int len = 1;
		int strLen = beginWord.length();
		HashSet<String> visited = new HashSet<String>();
		
		beginSet.add(beginWord);
		endSet.add(endWord);
		while (!beginSet.isEmpty() && !endSet.isEmpty()) {
			if (beginSet.size() > endSet.size()) {
				Set<String> set = beginSet;
				beginSet = endSet;
				endSet = set;
			}

			Set<String> temp = new HashSet<String>();
			for (String word : beginSet) {
				char[] chs = word.toCharArray();

				for (int i = 0; i < chs.length; i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						char old = chs[i];
						chs[i] = c;
						String target = String.valueOf(chs);

						if (endSet.contains(target)) {
							return len + 1;
						}

						if (!visited.contains(target) && wordList.contains(target)) {
							temp.add(target);
							visited.add(target);
						}
						chs[i] = old;
					}
				}
			}

			beginSet = temp;
			len++;
		}
		
		return 0;
	}
}



public class Solution {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
	    Set<String> bSet = new HashSet<String>(), eSet = new HashSet<String>();
	    bSet.add(beginWord); eSet.add(endWord);
	    wordList.remove(beginWord); wordList.remove(endWord);
	    int len = 2;
	    while(!bSet.isEmpty() && !eSet.isEmpty()){
	        Set<String> tSet = new HashSet<String>();
	        for(String str: bSet){
	            char[] chs = str.toCharArray();
	            for(int i = 0; i < chs.length; ++i){
	                char ch = chs[i];
	                for(char c = 'a'; c <= 'z'; ++c){
	                    if(c == ch) continue;
	                    chs[i] = c;
	                    String s = String.valueOf(chs);
	                    if(eSet.contains(s)){
	                        return len;
	                    }
	                    if(wordList.contains(s)){
	                        tSet.add(s);
	                    }
	                }
	                chs[i] = ch;
	            }
	        }
	        wordList.removeAll(tSet);
	        if(tSet.size() > eSet.size()){
	            bSet = eSet;
	            eSet = tSet;
	        }else bSet = tSet;
	        ++len;
	    }
	    return 0;
	}
}