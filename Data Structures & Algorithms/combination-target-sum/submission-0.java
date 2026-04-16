class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> subset = new ArrayList<>();
        dfs(nums, target, 0, subset);
        return result;
    }

    private void dfs(int[] nums, int target, int i, List<Integer> subset) {
        if (target == 0) {
            result.add(new ArrayList(subset));
            return;
        }

        if (i >= nums.length || target < 0) {
            return;
        }

        subset.add(nums[i]);
        dfs(nums, target - nums[i], i, subset);
        subset.remove(subset.size() - 1);
        dfs(nums, target, i + 1, subset);
    }
}
