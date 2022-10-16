class Solution {
    
    String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String hundred = "Hundred";
        String[] bigTens = {"","Thousand", "Million", "Billion"};
        
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        
        String str = Integer.toString(num);
        String[] arr = split(str);
        
        StringBuilder ans = new StringBuilder();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            String current = parseHunderds(arr[i]);
            if (current.length() == 0) continue;
            ans.append(current).append(" ");
            if (n - i - 1 > 0) {
                ans.append(bigTens[n - i - 1]).append(" ");
            }
        }
        
        ans.setLength(ans.length() - 1);
        return ans.toString();
        
    }
    
    String[] split(String str) {
        int len = str.length();
        if (len % 3 == 1) str = "00" + str;
        else if (len % 3 == 2) str = "0" + str;
        len = str.length();
        int n = len / 3;
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[i] = str.substring(3 * i, 3 * i + 3);
        }
        return ans;
    }
    
    String parseHunderds(String str) {
        StringBuilder sb = new StringBuilder();
        if (str.charAt(0) != '0') {
            int idx = str.charAt(0) - '0';
            sb.append(units[idx]).append(" ").append(hundred);
        }
        if (str.charAt(1) == '1') {
            int idx = str.charAt(2) - '0';
            if (sb.length() > 0) sb.append(" ");
            sb.append(teens[idx]);
            return sb.toString();
        } else if (str.charAt(1) > '1') {
            int idx = str.charAt(1) - '0';
            if (sb.length() > 0) sb.append(" ");
            sb.append(tens[idx]);
        }
        if (str.charAt(2) != '0') {
            int idx = str.charAt(2) - '0';
            if (sb.length() > 0) sb.append(" ");
            sb.append(units[idx]);
        } 
        return sb.toString();
    }
}
