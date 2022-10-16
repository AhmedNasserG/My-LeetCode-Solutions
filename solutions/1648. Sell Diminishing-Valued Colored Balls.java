class Solution {
    public int maxProfit(int[] inventory, int orders) {
        int mod = (int) 1e9 + 7;
        Arrays.sort(inventory);
        long ans = 0;
        int n = inventory.length;
        for (int i = n - 1; i >= 0; i--) {
            long diff = inventory[i] - (i > 0 ? inventory[i - 1] : 0);
            long count = n - i;
            long maxOrders = Math.min(orders, count * diff);
            orders -= maxOrders;
            
            long levels = maxOrders / count;
            long rem = maxOrders % count;
            
            ans = (ans + sum(inventory[i] - levels + 1, inventory[i], mod) * count) % mod;
            ans = (ans + (inventory[i] - levels) * rem) % mod;
            
        }
        return (int) ans;
    }
​
    long sum(long start, long end, int mod) {
        return ((sum(end, mod) - sum(start - 1, mod)) % mod + mod) % mod;
    }
        
    long sum(long n, long mod) {
        return n * (n + 1) / 2 % mod;
    }
    
}
