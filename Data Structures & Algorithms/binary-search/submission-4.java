// Practice
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int pivot;

        while (l <= r) {
            pivot = l + (r - l) / 2;
            if (nums[pivot] == target) {
                return pivot;
            } else if (nums[pivot] > target) {
                r = pivot - 1;
            } else {
                l = pivot + 1;
            }
        }
        return -1;
    }
}
