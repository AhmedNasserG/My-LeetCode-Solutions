class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }       
        if (sum % 3 != 0) {
            return false;
        }
        sum = sum / 3;
        int sumSoFar = 0;
        int numOfParts = 0;
        for (int num : arr) {
            sumSoFar += num;
            if (sumSoFar == sum) {
                sumSoFar = 0;
                numOfParts++;
            }
        }
        return numOfParts >= 3;
    }
}
​
