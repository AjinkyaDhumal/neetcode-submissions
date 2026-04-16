class Solution {

    public String encode(List<String> strs) {
        StringBuilder resultStr = new StringBuilder();
        for (String str : strs) {
            resultStr.append(str.length()).append('#').append(str);
        }
        return resultStr.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }
            int lengthOfString = Integer.parseInt(str.substring(i,j));
            i = j + 1;
            j = i + lengthOfString;
            result.add(str.substring(i,j));
            i = j;
        }
        return result;
    }
}
