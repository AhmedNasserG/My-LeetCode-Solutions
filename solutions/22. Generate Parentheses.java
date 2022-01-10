class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(ans, n, n, new char[2 * n], 0);
        return ans;
    }
    
    void generate(List<String> list, int remainLeft, int remainRight, char[] str, int index) {
        if (remainLeft < 0 || remainRight < remainLeft) {
            return;
        }
        
        if (remainLeft == 0 && remainRight == 0) {
            list.add(new String(str));
            return;
        }
        
        str[index] = '(';
        generate(list, remainLeft - 1, remainRight, str, index + 1);
        
        str[index] = ')';
        generate(list, remainLeft, remainRight - 1, str, index + 1);
    }
}
