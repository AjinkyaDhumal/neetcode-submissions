// Crazy bad own solution. Check solution 2.
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        result[0] = 1;
        result[1] = nums[0];
        for (int i = 2; i < length; i++) {
            result[i] = nums[i-1] * result[i-1];
        }

        int reverseProduct = nums[length -1];
        for (int i = nums.length - 2; i >= 0 ; i--) {
            result[i] = result[i] * reverseProduct;
            reverseProduct = reverseProduct * nums[i];
        }
        return result;
    }
} 
// 1,24,12,8

// 2,3,4,1,5,6
// 360,240,180,720,144,120

// 2,3,4,1,5,6
// 1,240,180,720,144,120