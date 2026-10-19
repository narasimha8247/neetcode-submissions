class Solution {
    int rows;
    int cols;
    public int orangesRotting(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int frc = 0;
        Queue<int[]> qu = new ArrayDeque<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    qu.offer(new int[] {i, j});
                }else if(grid[i][j]==1){
                    frc++;
                }
            }
        }

        if(frc==0){
            return 0;
        }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int minutes = 0;
        while (!qu.isEmpty()) {
            int qsize = qu.size();
            boolean isRotted = false;
            for (int i = 0; i < qsize; i++) {
                int[] cur = qu.poll();
                int r = cur[0];
                int c = cur[1];
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nc >= 0 && nr < rows && nc < cols
                        && grid[nr][nc] == 1) {
                        frc--;
                        grid[nr][nc] = grid[r][c] + 1;
                        qu.offer(new int[] {nr, nc});
                        isRotted = true;
                    }
                }
            }
            if(isRotted){
                minutes++;
            }
            
        }
        return frc==0 ? minutes : -1;
    }
}
