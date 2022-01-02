class WordDictionary {
​
    private HashMap<Integer, List<String>> map;
    
    public WordDictionary() {
        map = new HashMap<>();
    }
    
    public void addWord(String word) {
        int len = word.length();
        map.putIfAbsent(len, new ArrayList());
        map.get(len).add(word);
    }
    
    public boolean search(String word) {
        int len = word.length();
        List<String> list = map.getOrDefault(len, new ArrayList());
        for (String s : list) {
            if (isSame(word, s)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isSame(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i) && a.charAt(i) != '.') {
                return false;   
            }
        }
        return true;
    }
}
​
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
