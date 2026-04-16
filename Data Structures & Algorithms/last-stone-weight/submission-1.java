class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : stones) {
            minHeap.offer(i);
        }

        while (minHeap.size() >= 2) {
            int stone1 = minHeap.poll();
            int stone2 = minHeap.poll();
            int result = stone1 - stone2;
            if (result != 0) minHeap.offer(result);
        }
        return (minHeap.size() == 1) ? minHeap.poll() : 0;
    }
}
