class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        if (s.isEmpty()) return 0;
        int maxSubString = 1;
        int ssLength = 1;
        int l = 0, r = 1;
        charSet.add(s.charAt(l));
        while (r < s.length()) {
            if (charSet.contains(s.charAt(r))) {
                maxSubString = Math.max(maxSubString, ssLength);
                do {
                    charSet.remove(s.charAt(l));
                    ssLength--;
                } while (s.charAt(l++) != s.charAt(r));
            }
            ssLength++;
            charSet.add(s.charAt(r));
            r++;
        }
        maxSubString = Math.max(maxSubString, ssLength);
        return maxSubString;
    }
}
