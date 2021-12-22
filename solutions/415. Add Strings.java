class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry > 0) {
            int a = i >= 0 ? (num1.charAt(i--) - '0') : 0;
            int b = j >= 0 ? (num2.charAt(j--) - '0') : 0;
            int sum = a + b + carry;
            carry = sum >= 10 ? 1 : 0;
            sb.append(sum >= 10 ? sum - 10 : sum);
        }
        return sb.reverse().toString();
    }
}
