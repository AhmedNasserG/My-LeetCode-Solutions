class MagicDictionary {
    private String[] dict;
    public MagicDictionary() {
        
    }
    
    public void buildDict(String[] dictionary) {
        this.dict = dictionary;
    }
    
    public boolean search(String searchWord) {
        for (String str : dict) {
            if (hasOneCharDifferent(searchWord, str)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean hasOneCharDifferent(String a, String b) {
        if (a.length() != b.length()) return false;
        boolean oneDifferentChar = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) continue;
            if (!oneDifferentChar) {
                oneDifferentChar = true;
            } else {
                return false;
            }
        }
        return oneDifferentChar;
    }
}
​
/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
