class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() <2) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        Map <Character, Character> paraMap = new HashMap<>();
        paraMap.put(')', '(');
        paraMap.put(']', '[');
        paraMap.put('}', '{');

        for (char c : s.toCharArray()) {
            if (paraMap.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == paraMap.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
