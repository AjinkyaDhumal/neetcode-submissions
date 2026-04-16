class Solution {
    // recursive
    public int search(int[] nums, int target) {
        return recurse(0, nums.length - 1, nums, target);
    }
    private int recurse(int l, int r, int[] nums, int target) {
        if (l > r) return -1;
        int mid = l + (r -l) / 2;

        if (target == nums[mid]) return mid;
        else if (target < nums[mid])
            return recurse(l, mid - 1, nums, target);
        else return recurse(mid + 1, r, nums, target);
    }
}
