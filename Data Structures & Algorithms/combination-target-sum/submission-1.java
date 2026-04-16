class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> subset = new ArrayList<>();
        dfs(subset, 0, nums, target);
        return result;
    }

    private void dfs(List<Integer> subset, int i, int[] nums, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }

        if (i >= nums.length || target < 0) {
            return;
        }

        subset.add(nums[i]);
        dfs(subset, i, nums, target - nums[i]);
        subset.remove(subset.size() - 1);
        dfs(subset, i + 1, nums, target);
    }
}
