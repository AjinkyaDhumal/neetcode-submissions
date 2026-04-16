class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Practice
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(subset, 0, candidates, target);
        return result;
    }

    private void dfs(List<Integer> subset, int i, int[] nums, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }

        if (target < 0 || i >= nums.length) {
            return;
        }

        subset.add(nums[i]);
        dfs(subset, i + 1, nums, target - nums[i]);
        subset.remove(subset.size() - 1);

        while (i + 1 < nums.length &&
            nums[i] == nums[i + 1]) {
            i++;
            continue;
        }
        dfs(subset, i + 1, nums, target);
    }
}
