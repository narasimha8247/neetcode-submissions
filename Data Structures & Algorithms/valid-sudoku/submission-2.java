class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;

                int val = board[i][j] - '1'; // Convert '1'-'9' to index 0-8
                int boxIdx = (i / 3) * 3 + (j / 3);

                // Check if digit was already seen in row, column, or 3x3 box
                if (rows[i][val] || cols[j][val] || boxes[boxIdx][val]) {
                    return false;
                }

                // Mark digit as seen
                rows[i][val] = true;
                cols[j][val] = true;
                boxes[boxIdx][val] = true;
            }
        }

        return true;
    }
}
