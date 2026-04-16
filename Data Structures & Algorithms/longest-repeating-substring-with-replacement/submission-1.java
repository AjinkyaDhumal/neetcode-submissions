class Solution {
    public int characterReplacement(String s, int k) {
        
        int l = 0, maxf = 0;
        int result = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            // check for map and update.
            countMap.put(s.charAt(r), countMap.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, countMap.get(s.charAt(r)));
            // while (l count <= k)
                // l++
                // update count
            while ((r - l + 1) - maxf > k) {
                countMap.put(s.charAt(l), countMap.get(s.charAt(l)) - 1);
                l++;
            }
            result = Math.max(result, r - l + 1);
        }
        return result;
    }
}
