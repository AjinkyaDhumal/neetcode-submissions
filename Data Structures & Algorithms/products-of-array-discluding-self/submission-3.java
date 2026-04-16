// prepare suffic and prefix arrays as below
// final answer is simply the product of two arrays

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] pref = new int[n]; // Prefix product: pref[i] = product of all elements to the left of i
        int[] suff = new int[n]; // Suffix product: suff[i] = product of all elements to the right of i

        pref[0] = 1;
        suff[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            pref[i] = nums[i - 1] * pref[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = nums[i + 1] * suff[i + 1];
        }
        for (int i = 0; i < n; i++) {
            res[i] = pref[i] * suff[i];  // final answer is simply product of both
        }
        return res;
    }
}