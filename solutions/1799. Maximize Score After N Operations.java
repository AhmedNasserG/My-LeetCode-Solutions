class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                list.add(new Pair(nums[i], nums[j], gcd(nums[i], nums[j])));
            }
        }
        Collections.sort(list, (Pair a, Pair b) -> b.g - a.g);
        int ans = 0, op = n / 2;
        HashSet<Integer> visited = new HashSet<>();
        for (Pair p : list) {
            if (visited.contains(p.a) || visited.contains(p.b)) {
                continue;
            }
            ans += op * p.g;
            visited.add(p.a);
            visited.add(p.b);
        }
        return ans;
    }
    
    private class Pair {
        int a, b, g;
        Pair(int a, int b, int g) {
            this.a = a;    
            this.b = b;    
            this.g = g;    
        }
    }
    
    private int gcd(int a, int b) {
        return a == 0? b : gcd(b % a, a);
