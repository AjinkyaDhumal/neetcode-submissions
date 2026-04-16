// Min Heap - O(nlogk) solution - check code comments
// key part - 
// Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // initialize countMap - map<num, freq>
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num: nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // filter only top k elems into min heap
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll()[1];
        }
        return result;
    }
}
// Using a Max-Heap Instead of Min-Heap
// When keeping track of the top k elements, a min-heap of size k is needed 
// so you can efficiently remove the smallest frequency when the heap 
// exceeds size k. Using a max-heap requires storing all elements 
// and then extracting k times, which is less efficient. 
// The min-heap approach maintains only the k largest frequencies at any time.