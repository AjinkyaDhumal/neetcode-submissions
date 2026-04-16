// This solution sorts the hashmap based on values - freq of nums
// Get list of Map.Entry from hashMap and then -
// list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()))

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // initialize countMap - Map<num, freq>
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // sort
        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(countMap.entrySet());
        sortedList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        
        int[] resultArr = new int[k];
        for (int i = 0; i < k; i++) {
            resultArr[i] = sortedList.get(i).getKey();
        }
        return resultArr;
     }
}
 