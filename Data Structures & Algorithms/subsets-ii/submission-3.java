// Practice
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, subset, nums);
        return result;
    }

    private void dfs(int i, List<Integer> subset, int[] nums) {
        if (i == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(i + 1, subset, nums);
        subset.remove(subset.size() - 1);

        while(i + 1 < nums.length &&
            nums[i] == nums[i + 1]) i++;
        dfs(i + 1, subset, nums);
    }
}
