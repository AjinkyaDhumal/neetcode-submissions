// Create 3 hashmap -
// rMap for each row as key and set of char for values in that row (key)
// cMap for each col as key and set of char for values in that col (key)
// squareMap for each of the 9 squares, squareKey = (r/3) + "," + (c/3)
// square key for each square and its set of char for values in square
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, HashSet<Character>> rowMap = new HashMap<>();
        Map<Integer, HashSet<Character>> colMap = new HashMap<>();
        Map<String, HashSet<Character>> squareMap = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;

                String squareKey = (r/3) + "," + (c/3);
                if (rowMap.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c])
                    || colMap.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c])
                    || squareMap.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[r][c])) {
                        return false;
                }
                rowMap.get(r).add(board[r][c]);
                colMap.get(c).add(board[r][c]);
                squareMap.get(squareKey).add(board[r][c]);
            }
        }
        return true;
    }
}
