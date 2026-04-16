class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && stack.peek()[0] < t) {
                int[] top = stack.pop();
                result[top[1]] = i - top[1];
            }
            stack.push(new int[] {t, i});
        }
        return result;
    }
}

//3, 7, 5, 8, 9, 2, 1, 5

// 1, 2, 1, 1, 0, 2, 1, 0