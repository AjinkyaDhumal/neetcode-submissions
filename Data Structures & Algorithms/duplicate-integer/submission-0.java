class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (numMap.get(num) == null) {
                numMap.put(num, 1);
            }
            else return true;
        }
        return false;
    }
}