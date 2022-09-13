import java.util.*;

class Solution {

    public static int splitPrimes(String inputStr) {
        sieve(1000);
        return solve(inputStr, 0);
    }
    
    static boolean[] isPrime;
    static void sieve(int n) {
        isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
    }
    
    static int solve(String str, int i) {
        if (i == str.length()) return 1;
        int ans = 0;
        for (int j = 1; j <= Math.min(3, str.length() - i); j++) {
            if (i + j < str.length() && str.charAt(i + j) == '0') continue;
            if (isPrime[Integer.parseInt(str.substring(i, i + j))]) {
                ans += solve(str, i + j);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        scanner.close();
        int res = splitPrimes(inputStr);
        System.out.println(res);
    }
}
