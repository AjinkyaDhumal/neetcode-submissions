class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : stones) {
            maxHeap.offer(i);
        }

        while (maxHeap.size() >= 2) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            int result = stone1 - stone2;
            if (result != 0) maxHeap.offer(result);
        }
        return (maxHeap.size() == 1) ? maxHeap.poll() : 0;
    }
}
