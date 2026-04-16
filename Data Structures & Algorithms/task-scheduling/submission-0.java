class Solution {

    // convert letters to counts[]
    // use a maxHeap to maintain all the counts
    // use Queue so that you can move the elements from maxheap 
    // that you are not supposed to process when its time has not come yet
    // when its time to process the element, it can be moved back to heap from q
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }

        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int c : count) {
            if (c > 0) {
                maxHeap.add(c);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0)
                    q.add(new int[] {cnt, time + n});
            } else {
                time = q.peek()[1];
            }

            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.add(q.poll()[0]);
            }
        }
        return time;
    }
}
