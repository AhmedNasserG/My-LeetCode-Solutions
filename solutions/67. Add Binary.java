class Solution {
    StringBuilder sb;
    public String addBinary(String a, String b) {
        sb = new StringBuilder(Math.max(a.length(), b.length()) + 1);
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int num1 = i >= 0 ? (a.charAt(i--) - '0') : 0;
            int num2 = j >= 0 ? (b.charAt(j--) - '0') : 0;
            carry = addBit(num1, num2, carry);
        }
        if (carry != 0) {
            addBit(0, 0, carry);
        }
        return sb.reverse().toString();
    }
    
    private int addBit(int a, int b, int carry) {
        int sum = a + b + carry;
        sb.append("" + (sum % 2));
        return sum / 2;
    }
}
