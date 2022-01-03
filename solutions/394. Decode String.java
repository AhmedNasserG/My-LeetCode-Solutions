class Solution {
    public String decodeString(String s) {↔}
    
    class Index {↔}
    
    private String decodeString(String s, Index idx) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (idx.val < s.length()) {
            char c = s.charAt(idx.val);
            if (c == '[') {
                idx.val++;
                String tempStr = decodeString(s, idx);
                while (count > 0) {
                    sb.append(tempStr);
                    count--;
                }
            } else if (c == ']') {
                return sb.toString();
            } else if (c >= '0' && c <= '9') {
                count = count * 10 + (c - '0');
            } else {
                sb.append(c);
            }
            idx.val++;
        }
        return sb.toString();
    }
}
