class Solution {
    int rows;
    int cols;
    public int maxAreaOfIsland(int[][] grid) {
        int count = 0;
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] vis = new boolean[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(!vis[i][j] && grid[i][j]==1){
                    count = Math.max(count,isIsland(grid, i, j, vis));
                }
            }
        }
        return count;
    }

    public int isIsland(int[][] grid, int i, int j, boolean[][] vis){
        if(i<0 || j<0 || i>=rows || j>=cols || vis[i][j]){
            return 0;
        }

        if(grid[i][j]==0){
            return 0;
        }

        vis[i][j] = true;
        int right = isIsland(grid, i, j+1, vis);
        int left = isIsland(grid, i, j-1, vis);
        int up = isIsland(grid, i+1, j, vis);
        int down = isIsland(grid, i-1, j, vis);
        return 1+right+left+up+down;
    }
}
