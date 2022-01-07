class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean numSeen = false;
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numAfterESeen = true;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                numSeen = true;
                if (eSeen) {
                    numAfterESeen = true;
                }
            } else if (c == '.') {
                if (pointSeen || eSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (c == 'e' || c == 'E') {
                if (eSeen || !numSeen) {
                    return false;
                }
                eSeen = true;
                numAfterESeen = false;
            } else if (c == '-' || c == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numSeen && numAfterESeen;
    }
}
