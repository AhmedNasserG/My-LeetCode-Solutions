class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        TrieNode trie = buildTrie(words);
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, trie, ans);
            }    
        }
        return ans;
    }
    
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};
    
    public void dfs(char[][] board, int row, int col, TrieNode trie, List<String> list) {
        char c = board[row][col];
        if (c == '#' || trie.next[c - 'a'] == null) return;
        trie = trie.next[c - 'a'];
        if (trie.word != null) {
            list.add(trie.word);
            trie.word = null;
        }
        board[row][col] = '#';
        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i], newCol = col + dc[i];
            if (inBound(board, newRow, newCol)) {
                dfs(board, newRow, newCol, trie, list);
            }
        }
        board[row][col] = c;
    }
    
    public boolean inBound(char[][] board, int r, int c) {
        return 0 <= r && r < board.length && 0 <= c && c < board[0].length;
    }
    
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
