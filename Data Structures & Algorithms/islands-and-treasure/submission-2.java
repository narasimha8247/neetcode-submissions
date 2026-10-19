class Solution {
    int rows;
    int cols;
    public void islandsAndTreasure(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        Queue<int[]> qu = new ArrayDeque<>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]==0){
                    qu.offer(new int[]{i,j});
                }
            }
        }

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        while(!qu.isEmpty()){
            int[] cur = qu.poll();
            int r = cur[0];
            int c = cur[1];
            for(int[] dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr>=0 && nc>=0 && nr<rows && nc<cols && grid[nr][nc]==Integer.MAX_VALUE){
                    grid[nr][nc] = grid[r][c]+1;
                    qu.offer(new int[]{nr,nc});
                }
            }
            
        }
    }

    class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}
