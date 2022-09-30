class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> list = new HashSet(wordList);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int ans = 0;
        while (!q.isEmpty()) {
            int levelSize = q.size();
            ans++;
            while (levelSize-- > 0) {
                String cur = q.remove();
                if (cur.equals(endWord)) return ans;
                char[] curArr = cur.toCharArray();
                for (int i = 0; i < cur.length(); i++) {
                    char oldChar = curArr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        curArr[i] = c;
                        String next = new String(curArr);
                        if (!list.contains(next)) continue;
                        list.remove(next);
                        q.add(next);
                    }
                    curArr[i] = oldChar;
                }
            }
        }
        return 0;
    }
}
