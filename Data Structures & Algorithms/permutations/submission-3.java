class Solution {
    // Practice
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> subSet = new ArrayList<>();
        dfs(subSet, nums);
        return result;
    }

    private void dfs(List<Integer> subSet, int[] nums) {
        if (nums.length == subSet.size()) {
            result.add(new ArrayList<>(subSet));
            return;
        }

        for (int num: nums) {
            if (subSet.contains(num)) continue;
            subSet.add(num);
            dfs(subSet, nums);
            subSet.remove(subSet.size() - 1);
        }
    }
}
