class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int ans = 0;
        for (int[] box : boxTypes) {
            int numOfBoxes = Math.min(box[0], truckSize);
            ans += numOfBoxes * box[1];
            truckSize -= numOfBoxes;
            if (truckSize == 0) return ans;
        }
        return ans;
    }
}
