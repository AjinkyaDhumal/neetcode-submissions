class Solution {
    public int trap(int[] height) {
        int i = 0,  j = height.length -1;
        int maxLeft = height[i];
        int maxRight = height[j];
        int result = 0;
        while (i < j) {
            int intMinLeftRight = Math.min(maxLeft, maxRight);
            int waterAtPos = 0;
            if (maxLeft <= maxRight) {
                i++;
                waterAtPos = intMinLeftRight - height[i];
                maxLeft = Math.max(maxLeft, height[i]);
            } else {
                j--;
                waterAtPos = intMinLeftRight - height[j];
                maxRight = Math.max(maxRight, height[j]);
            }
            waterAtPos = waterAtPos < 0 ? 0 : waterAtPos;
            result = result + waterAtPos;
        }
        return result;
    }
}
