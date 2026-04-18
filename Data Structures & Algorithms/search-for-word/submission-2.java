// Practice
class Solution {
    private int ROWS;
    private int COLS;
    Set<Pair<Integer, Integer>> path = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (backtrack(r, c, board, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(int r, int c, char[][] board, String word, int i) {
        if (i == word.length()) {
            return true;
        }

        if (r < 0 || c < 0 || r >= ROWS || c >= COLS
            || board[r][c] != word.charAt(i)
            || path.contains(new Pair<>(r, c))) {
                return false;
        }

        path.add(new Pair<>(r, c));
        boolean result = backtrack(r + 1, c, board, word, i + 1)
                      || backtrack(r - 1, c, board, word, i + 1)
                      || backtrack(r, c + 1, board, word, i + 1)
                      || backtrack(r, c - 1, board, word, i + 1);
        path.remove(new Pair<>(r, c));
        return result;
    }
}
