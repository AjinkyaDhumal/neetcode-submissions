class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> sortedList = new ArrayList<>();
        // Arrays.stream(nums)
        //         .sorted()
        //         .boxed()
        //         .toList();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int j = 1;
        for (int i = 0; i < j; i++) {
            j = i + 1;
            int k = nums.length -1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> targetList = Arrays.asList(nums[i], nums[j], nums[k]);
                    if(!result.contains(targetList)) {
                        result.add(targetList);
                    }
                    j++;
                    k--;
                } else if(nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}
// [-4, -1, -1, 0, 1, 2]
