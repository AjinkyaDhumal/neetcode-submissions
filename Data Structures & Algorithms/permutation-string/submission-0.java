class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];
        int matches = 0;

        for (int i = 0; i < s1.length(); i++) {
            s1Arr[s1.charAt(i) - 'a']++;
            s2Arr[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (s1Arr[i] == s2Arr[i]) {
                matches++;
            }
        }

        for (int l = 0, r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) return true;
            
            int index = s2.charAt(r) - 'a';
            s2Arr[index]++;
            if (s1Arr[index] == s2Arr[index]) matches++;
            else if (s1Arr[index] + 1 == s2Arr[index]) matches--;

            index = s2.charAt(l) - 'a';
            s2Arr[index]--;
            if (s1Arr[index] == s2Arr[index]) matches++;
            else if (s1Arr[index] - 1 == s2Arr[index]) matches--;

            l++;
        }
        return matches == 26;
    }
}
