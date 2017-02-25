public class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.charAt(0) >= 'a') {
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) < 'a') {
                    return false;
                }
            }
        } else {
            boolean allCap = true;
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) <= 'Z') {
                    if (!allCap) {
                        return false;
                    }
                } else {
                    if (i > 1 && allCap) {
                        return false;
                    }
                    allCap = false;
                }
            }
        }
        return true;
    }
}


public class Solution {
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }
}