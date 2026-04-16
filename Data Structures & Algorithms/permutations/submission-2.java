class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        dfs(subset, nums);
        return result;
    }

    private void dfs(List<Integer> subset, int[] nums) {
        if (subset.size() == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        for (int num : nums) {
            if (subset.contains(num)) continue;
            subset.add(num);
            dfs(subset, nums);
            subset.remove(subset.size() - 1);
        }
    }
}
