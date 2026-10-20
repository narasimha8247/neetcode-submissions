class Solution {
    List<List<Integer>> pac = new ArrayList<>();
    List<List<Integer>> atl = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    int rows;
    int cols;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pacvis = new boolean[rows][cols];
        boolean[][] atvis = new boolean[rows][cols];

        for(int i=0;i<rows; i++){
            pac(heights, i, 0, pacvis);
        }
        for(int j=0;j<cols; j++){
            pac(heights, 0, j, pacvis);
        }
        for(int i=0;i<rows; i++){
            pac(heights, i, cols-1, atvis);
        }
        for(int j=0;j<cols; j++){
            pac(heights, rows-1, j, atvis);
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacvis[i][j] && atvis[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        
        return res;
    }

    public void pac(int[][] grid, int i, int j, boolean[][] vis){
        vis[i][j] = true;
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] dir : directions){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr>=0 && nc>=0 && nr<rows && nc<cols && 
                    !vis[nr][nc] &&
                    grid[i][j]<=grid[nr][nc]){
                pac(grid,nr,nc,vis);        
            }
        }


    }
}
