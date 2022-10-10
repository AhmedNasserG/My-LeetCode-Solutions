class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList();
        
        List<String> lineArr = new ArrayList();
        int lineSize = 0;
        for (String word : words) {
            if (lineSize + word.length() > maxWidth) {
                lines.add(createLine(lineArr, lineSize - 1, maxWidth));
                lineArr = new ArrayList();
                lineSize = 0;
            }
            lineSize += word.length() + 1;
            lineArr.add(word);
        }
        StringBuilder lastLine = new StringBuilder();
        for (String word : lineArr) {
            lastLine.append(word).append(" ");
        }
        int n = lastLine.length();
        for (int i = n; i < maxWidth; i++) lastLine.append(" ");
        lastLine.setLength(maxWidth);
        
        lines.add(lastLine.toString());
        return lines;
    }
    
    private String createLine(List<String> list, int charCount, int maxWidth) {
        int spaceCount = maxWidth - charCount;
        int spacePlaces = list.size() - 1;
        int eachPlace = spaceCount / Math.max(spacePlaces, 1);
        int rem = spaceCount % Math.max(spacePlaces, 1);
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append(" ");
            for (int i = 0; i < eachPlace; i++) sb.append(" ");
            if (rem > 0) {
                sb.append(" ");
                rem--;
            }
        }
        sb.setLength(maxWidth);
        return sb.toString();
    }
}
