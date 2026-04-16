class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<String, List<String>>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String sKey = Arrays.toString(count);
            resultMap.putIfAbsent(sKey, new ArrayList<>());
            resultMap.get(sKey).add(s);
        }
        return new ArrayList<>(resultMap.values());
    }
}
