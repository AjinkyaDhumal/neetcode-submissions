class Solution {
    List<String> result = new ArrayList<>();
    StringBuilder subset = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        dfs(0, 0, n);
        return result;
    }

    private void dfs(int openN, int closedN, int n) {

        if (openN == closedN && openN == n) {
            result.add(subset.toString());
            return;
        }

        if (openN < n) {
            subset.append("(");
            dfs(openN + 1, closedN, n);
            subset.deleteCharAt(subset.length() - 1);
        }

        if (closedN < openN) {
            subset.append(")");
            dfs(openN, closedN + 1, n);
            subset.deleteCharAt(subset.length() - 1);
        }
    }
}
