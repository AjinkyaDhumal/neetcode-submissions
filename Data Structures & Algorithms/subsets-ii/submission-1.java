class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> subSet = new ArrayList<>();
        Arrays.sort(nums);
        dfs(subSet, 0, nums);
        return result;
    }

    private void dfs(List<Integer> subSet, int i, int[] nums) {
        if (i == nums.length) {
            if (!result.contains(subSet))
                result.add(new ArrayList<>(subSet));
            return;
        }

        subSet.add(nums[i]);
        dfs(subSet, i + 1, nums);
        while (i == i + 1) {
            i++;
        }
        subSet.remove(subSet.size() - 1);
        dfs(subSet, i + 1, nums);
    }
}
