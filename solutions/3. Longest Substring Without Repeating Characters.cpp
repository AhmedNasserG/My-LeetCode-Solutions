class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> map;
        int ans = 0;
        int startIdx = 0;
        for(int i = 0; i < s.size(); i++) {
            if(map.count(s[i]) > 0) startIdx = max(map[s[i]] + 1, startIdx);
            ans = max(ans, i - startIdx + 1);
            map[s[i]] = i;
        }
        return ans;
    }
};
​
