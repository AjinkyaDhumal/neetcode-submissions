// Here instead of list.contains you simply skip the duplicate i

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, subset);
        return result;
    }

    private void dfs(int[] nums, int target, int i, List<Integer> subset) {
        if (target == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }

        if (i >= nums.length || target < 0) {
            return;
        }

        subset.add(nums[i]);
        dfs(nums, target - nums[i], i + 1, subset);

        while (i + 1 < nums.length &&
            nums[i] == nums[i + 1]) i = i + 1;
        subset.remove(subset.size() - 1);
        dfs(nums, target, i + 1, subset);
    }
}
