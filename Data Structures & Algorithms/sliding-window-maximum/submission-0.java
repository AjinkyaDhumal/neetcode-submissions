class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int l = 0;
        int[] maxList = new int[nums.length - k + 1];
        int pos = 0;
        for (int r = 0; r < nums.length; r++) {
            pq.add(nums[r]);
            
            if (r == l + k -1) {
                maxList[pos] = pq.peek();
                pq.remove(nums[l]);
                pos++;
                l++;
            }
        }
        return maxList;
     }
}
