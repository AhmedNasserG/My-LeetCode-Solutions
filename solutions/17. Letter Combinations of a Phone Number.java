class Solution {
     private String[] map = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
​
    
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() > 0) {
            wave(ans, 0, "", digits.toCharArray());
        }        
        return ans;
    }
    
    private void wave(List<String> list, int idx, String temp, char[] digits) {
        if (temp.length() == digits.length) {
            list.add(temp);
            return;
        }
        
        for (char c : map[digits[idx] - '0'].toCharArray()) {
            wave(list, idx + 1, temp + c, digits);
        }
    }
}
