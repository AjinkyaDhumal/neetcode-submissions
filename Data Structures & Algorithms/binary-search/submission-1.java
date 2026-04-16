class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        int pivot = (end / 2);
        while (nums[pivot] != target) {
            if (start >= end) {
                return -1;
            }

            if (target < nums[pivot]) {
                end = pivot -1;
            } else if (target > nums[pivot]) {
                start = pivot + 1;
            }
            pivot = (start + (end - start) / 2);
        }
        return pivot;
    }
}
