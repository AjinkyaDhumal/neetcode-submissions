class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deq = new ArrayDeque<>();
        int pos = 0;
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {

            // remove left if outside of wondow
            if (!deq.isEmpty() && deq.peekFirst() <= i - k) {
                deq.pollFirst();
            }

            // remove smaller elements from the right
            while (!deq.isEmpty() && nums[deq.peekLast()] < nums[i]) {
                deq.pollLast();
            }

            // Add new element
            deq.offerLast(i);

            // update output once window is full
            if (i >= k -1) {
                res[pos++] = nums[deq.peekFirst()];
            }
        }
        return res;
    }
}
