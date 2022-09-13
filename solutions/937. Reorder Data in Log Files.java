​
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        String[] ans = new String[logs.length];
        List<String> lettersAns = new ArrayList<>();
        List<String> digitsAns = new ArrayList<>();
        for (String log : logs) {
            String[] arr = log.split(" ");
            if (Character.isDigit(arr[1].charAt(0))) {
                digitsAns.add(log);
            } else {
                lettersAns.add(log);
            }         
               
            Collections.sort(lettersAns, (a, b) -> {
                String log1 = a.split(" ", 2)[1];
                String log2 = b.split(" ", 2)[1];
                return log1.equals(log2) ? a.compareTo(b) : log1.compareTo(log2);
            });
            
            int i = 0;
            for (String k: lettersAns) {
                ans[i++] = k;
            }
            for (String k: digitsAns) {
                ans[i++] = k;
            }
        }
        return ans;
    }
}
