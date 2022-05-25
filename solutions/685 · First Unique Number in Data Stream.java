public class Solution {
    
    public int firstUniqueNumber(int[] nums, int number) {
        HashSet<Integer> dup = new HashSet<>();
        LinkedHashSet<Integer> unique = new LinkedHashSet<>();
        for (int num : nums) {
            if (dup.contains(num)) continue;
            if (unique.contains(num)) {
                unique.remove(num);
                dup.add(num);
            } else {
                unique.add(num);
            }
            if (num == number) return unique.iterator().next();
        }
        return -1;
    }
  
}
