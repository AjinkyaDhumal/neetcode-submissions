class Solution {
    public int search(int[] nums, int target) {
        /*  If your mid and l are in left sorted array i.e. nums[l] < nums[mid]
                && if target > nums[mid] or target < nums[l] then search in right sorted array
                else search in left sorted array
            else // lly if mid and r are in right sorted array
                if target > nums[r] or target < nums[mid] search in left sorted array
                else search in right sorted array
        */
        // In my solution I am clubbing both if else. which is less readable.
        // Check authors soliton for readability
         int l = 0, r = nums.length - 1;
         
         while (l <= r) {
            
            int mid = (l + r) / 2;
            if (target == nums[mid]) return mid;
            if (nums[l] == target) return l;
            if (nums[r] == target) return r;

            // Search left portion if -
            if ((nums[l] <= nums[mid] 
                && (target < nums[mid] && target > nums[l]))
                || (nums[mid] <= nums[r]
                && (target > nums[r] || target < nums[mid]))) {
                r = mid -1;
            } else {
                l = mid + 1;
            }
         }
        return -1;
    }
}
