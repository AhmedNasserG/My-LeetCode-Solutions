import java.util.Scanner;

class Solution {
    public static int counting(String s) {
        int prevSize = 0, currentSize = 0, ans = 0;
        char cur = '*';
        for (char c : s.toCharArray()) {
          if (c != cur) {
            cur = c;
            ans += Math.min(prevSize, currentSize);
            prevSize = currentSize;
            currentSize = 0;
          }
          currentSize++;
        }
        ans += Math.min(prevSize, currentSize);
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        int res = counting(s);
        System.out.println(res);
    }
}
