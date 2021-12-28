class Solution {
    public String removeDuplicates(String s) {
        // Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == s.charAt(i)) {
                sb.setLength(sb.length() - 1);
            } else {
                sb.append(s.charAt(i));
            }
        }
​
        return sb.toString();
    }
}
​
