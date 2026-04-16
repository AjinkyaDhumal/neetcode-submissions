class Solution {
    public int findDuplicate(int[] nums) {
        // 1. The array vals can be treated as pinters in linked list. So where theres a loop i.e. 
        // duplicate numbers, that starting point will be your reslt.
        // First you move slow pointer by 1 and fast pointer by 2.
        // Note the point of there intersection. It will take 2 loops of fast pointer over the loop.
        // Floyds algorithm - After this intersection increment slow from start and fast from 
        // intersection point each by one. The point where they meet is the start of the loop
        // which is our duplicate.

        // Note Negative marking looks way simpler. but it modifies the array.
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
