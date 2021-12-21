class Solution {
    private HashMap<Character, Integer> window;
    private HashMap<Character, Integer> tMap;
    private HashSet<Character> missingChars;
    private int ansStartIdx;
    private int ansMinSize;
    
    public String minWindow(String s, String t) {
        window = new HashMap<>();
        tMap = new HashMap<>();
        missingChars = new HashSet<>();
        ansMinSize = Integer.MAX_VALUE;
        ansStartIdx = -1;
  
        fillTMap(t);
        
        char[] sArr = s.toCharArray();
        int left = 0, right = 0, n = sArr.length;
        
        while (right < n) {
            addToWindow(sArr[right++]);
            while (left <= right && isASolution()) {
                updateAnswer(left, right);
                removeFromWindow(sArr[left++]);
            }
        }
        
        if (ansStartIdx == -1) {
            return "";
        }
        
        return s.substring(ansStartIdx, ansStartIdx + ansMinSize);
    }
    
    private void fillTMap(String str) {
        for (char c : str.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
            missingChars.add(c);
        }
    }
    
    private void addToWindow(char c) {
        int count = window.getOrDefault(c, 0) + 1;
        window.put(c, count);
        if (missingChars.contains(c) && tMap.get(c) <= count) {
            missingChars.remove(c);
        }
    }
    
    private void removeFromWindow(char c) {
        int count = window.getOrDefault(c, 1) - 1;
        if (count == 0) {
            window.remove(c);
        } else {
            window.put(c, count);
        }
        
        if (tMap.containsKey(c) && tMap.get(c) > count) {
            missingChars.add(c);
        }
    }
    
    private boolean isASolution() {
        return missingChars.isEmpty();
    }
    
    private void updateAnswer(int left, int right) {
        if (right - left < ansMinSize) {
            ansMinSize = right - left;
            ansStartIdx = left;
        }
    }
}
