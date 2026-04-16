class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Get a count map
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num: nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        // Initialize an countArr {{5,6},{}, {2}, {3,4}, {}}
        List<Integer>[] countArr = new List[nums.length];
        for (int i = 0; i < countArr.length; i++) {
            countArr[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> countEntry : countMap.entrySet()) {
            countArr[countEntry.getValue() - 1].add(countEntry.getKey());
        }

        int[] resultArr = new int[k];
        int j = 0;
        // Get top k elements
        for (int i = countArr.length -1; i >= 0 && k > 0; i--) {
            for (int res : countArr[i]) {
                resultArr[j] = res;
                k--;
                j++;
                if (k == 0) return resultArr;
            }
        }
        return resultArr;

     }
}
 