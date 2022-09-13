class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxW = 0, maxH = 0;
        
        for (int i = horizontalCuts.length - 1; i >= 0; i--) {
            maxH = Math.max(maxH, h - horizontalCuts[i]);    
            h = horizontalCuts[i];
        }
        maxH = Math.max(maxH, h - 0); 
        
        for (int i = verticalCuts.length - 1; i >= 0; i--) {
            maxW = Math.max(maxW, w - verticalCuts[i]);    
            w = verticalCuts[i];
        }
        maxW = Math.max(maxW, w - 0);  
        
        return (int) (1L * maxH * maxW % ((long) 1e9+7));
    }
}
