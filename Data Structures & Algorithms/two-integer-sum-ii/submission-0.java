class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (sumMap.containsKey(target - numbers[i])) {
                return new int[] {sumMap.get(target - numbers[i]) + 1, i +1};
            }
            sumMap.put(numbers[i], i);
        }
        return new int[] {0,0};
    }
}
