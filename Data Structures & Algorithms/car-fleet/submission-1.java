class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int length = position.length;
        int[][] fleetArr = new int[length][2];
        Stack<Double> resultStack = new Stack<>();
        for (int i = 0; i < length; i++) {
            fleetArr[i][0] = position[i];
            fleetArr[i][1] = speed[i];
        }
        Arrays.sort(fleetArr, (a, b) -> Integer.compare(b[0], a[0]));
        for (int[] arr : fleetArr) {
            double time = (double)(target - arr[0]) / arr[1];
            if (resultStack.isEmpty() || time > resultStack.peek()) {
                resultStack.push(time);
            }
        }
        return resultStack.size();
    }
}
