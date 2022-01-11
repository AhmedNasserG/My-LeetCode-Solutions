class Solution {
    public static String countAndSay(int n) {
        String str = "1";
        for (int i = 0; i < n - 1; i++) {
            str = helper(str);
        }
​
        return str;
    }
​
    static String helper(String curStr) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < curStr.length(); ) {
            char curNum = curStr.charAt(i);
            int count = 0;
            for (int j = i; j < curStr.length(); j++) {
                if (curNum == curStr.charAt(j)) {
                    count++;
                    i++;
                } else {
                    break;
                }
            }
            res.append(count);
            res.append(curNum);
        }
        return res.toString();
    }
}
