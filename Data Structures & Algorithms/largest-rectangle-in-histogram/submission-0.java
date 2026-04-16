class Solution {
    public int largestRectangleArea(int[] heights) {
        int startIndex = 0;
        int maxArea = 0;
        Stack<int[]> stackHeights = new Stack<>();
        
        for (int i = 0; i < heights.length; i++) {
            startIndex = i;
            while (!stackHeights.isEmpty() && stackHeights.peek()[1] > heights[i]) {
                int[] popElem = stackHeights.pop();
                int popIndex = popElem[0];
                int popHeight = popElem[1];
                maxArea = Math.max(maxArea, popHeight * (i - popIndex));
                startIndex = popIndex;
            }
            stackHeights.push(new int[] {startIndex, heights[i]});
        }
        while(!stackHeights.isEmpty()) {
            int[] popElem = stackHeights.pop();
            int popIndex = popElem[0];
            int popHeight = popElem[1];
            maxArea = Math.max(maxArea, popHeight * (heights.length - popIndex));
        }
        return maxArea;
    }
}
