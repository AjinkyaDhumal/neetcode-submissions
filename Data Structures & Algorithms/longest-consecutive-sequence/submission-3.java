class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        // Copy all array to hash set
        Set<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            numSet.add(num);
        }

        // // Find the start of each sequence and copy to list
        // List<Integer> seqStart = new ArrayList<>();
        // for (int num: nums) {
        //     if(numSet.contains(num+1)
        //         && !numSet.contains(num-1)) {
        //         seqStart.add(num);
        //     }
        // }

        // Starting with each start of seq, check which seq is largest
        int resMax = 1;
        for(int num: numSet) {
            if (!numSet.contains(num-1) && (numSet.contains(num+1))) {
                int seqMax = 1;
                while (numSet.contains(++num)) {
                    seqMax++;
                }
                if (seqMax > resMax) {
                    resMax = seqMax;
                }
                seqMax = 1;
            }
        }
        return resMax;
    }
}
