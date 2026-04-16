class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0, end = m - 1;
        while (start <= end) {
            int row  = (start + end) / 2;
            if (target < matrix[row][0]) {
                end = row - 1;
            } else if (target > matrix[row][n -1]) {
                start = row + 1;
            } else {
                break;
            }
        }

        if (!(start <= end)) {
            return false;
        }
        int row = (start + end) / 2;
        start = 0;
        end = n - 1;
        while (start <= end) {
            int mid  = (start + end) / 2;
            if (target < matrix[row][mid]) {
                end = mid - 1;
            } else if (target > matrix[row][mid]) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}