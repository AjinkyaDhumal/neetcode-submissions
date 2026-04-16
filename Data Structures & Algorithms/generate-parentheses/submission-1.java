class Solution {
    // Practice
    List<String> result = new ArrayList<>();
    StringBuilder stack = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        dfs(0, 0, n);
        return result;
    }

    private void dfs(int openN, int closedN, int n) {
        if (openN == n && closedN == openN) {
            result.add(stack.toString());
            return;
        }

        if (openN < n) {
            stack.append('(');
            dfs(openN + 1, closedN, n);
            stack.deleteCharAt(stack.length() - 1);
        }

        if (closedN < openN) {
            stack.append(')');
            dfs(openN, closedN + 1, n);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}
