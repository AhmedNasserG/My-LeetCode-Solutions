class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> freq = new HashMap();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList(freq.entrySet());
        Collections.sort(list, (a, b) -> a.getValue() - b.getValue());
        int ans = list.size();
        for (Map.Entry<Integer, Integer> e : list) {
            if (k < e.getValue()) break;
            k -= e.getValue();
            ans--;
        }
        return ans;
    }
}
