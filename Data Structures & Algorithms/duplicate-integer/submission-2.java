class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        numSet.addAll(Arrays.stream(nums).boxed().collect(Collectors.toSet()));
        return numSet.size() < nums.length;
    }
}