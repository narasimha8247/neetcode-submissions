class Solution {
    int rows;
    int cols;
    public int numIslands(char[][] grid) {
        int count = 0;
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] vis = new boolean[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    System.out.println(i+" "+j);
                    count++;
                    isIsland(grid, i, j, vis);
                }
            }
        }
        return count;
    }

    public void isIsland(char[][] grid, int i, int j, boolean[][] vis){
        if(i<0 || j<0 || i>=rows || j>=cols || vis[i][j]){
            return;
        }

        if(grid[i][j]=='0'){
            return;
        }

        vis[i][j] = true;
        isIsland(grid, i, j+1, vis);
        isIsland(grid, i, j-1, vis);
        isIsland(grid, i+1, j, vis);
        isIsland(grid, i-1, j, vis);
    }
}
