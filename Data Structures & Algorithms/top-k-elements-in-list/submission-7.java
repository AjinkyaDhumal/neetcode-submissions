// Bucket sort - O(n) solution
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        // initialize countMap - Map<num, freq>
        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        // Initialize bucket - Array of arraylist
        // this bucket will store the nums list at the index of its freq
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // Fill the bucket array with countMap value/frequency as index
        // and the nums with those frequencies as list at that index
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        // Starting from the end of bucket (highest frequency of elements)
        // return the result for upto k elements
        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }
}