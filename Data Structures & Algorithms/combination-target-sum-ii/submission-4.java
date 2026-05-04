// Practice
class Solution {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return result;
    }

    private void backtrack(int[] nums, int target, int i) {
        if (target == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }

        if (target < 0 || i >= nums.length) {
            return;
        }

        subset.add(nums[i]);
        backtrack(nums, target - nums[i], i + 1);
        
        while(i + 1 < nums.length && nums[i] == nums[i + 1])
            i++;
        subset.remove(subset.size() - 1);
        backtrack(nums, target, i + 1);
    }
}
