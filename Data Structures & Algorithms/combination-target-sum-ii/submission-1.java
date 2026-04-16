class Solution {
    List<List<Integer>> result = new ArrayList<>();
    // Set<Integer> visited = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, subset);
        return result;
    }

    private void dfs(int[] nums, int target, int i, List<Integer> subset) {
        if (target == 0) {
            if (!result.contains(subset))
                result.add(new ArrayList<>(subset));
            return;
        }

        if (i >= nums.length || target < 0) {
            return;
        }

        // visited.add(i);
        subset.add(nums[i]);
        dfs(nums, target - nums[i], i + 1, subset);
        subset.remove(subset.size() - 1);
        dfs(nums, target, i + 1, subset);
    }
}
