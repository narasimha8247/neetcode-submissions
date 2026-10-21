class Solution {
    int rows;
    int cols;

    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;
        boolean[][] vis = new boolean[rows][cols];
        for(int j=0; j<cols; j++){
            if(board[0][j]=='O'){
                dfs(board, 0, j, vis);
            }
        }
        for(int i=0; i<rows; i++){
            if(board[i][0]=='O'){
                dfs(board, i, 0, vis);
            }
        }
        for(int j=0; j<cols; j++){
            if(board[rows-1][j]=='O'){
                dfs(board, rows-1, j, vis);
            }
        }
        for(int i=0; i<rows; i++){
            if(board[i][cols-1]=='O'){
                dfs(board, i, cols-1, vis);
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='Y'){
                    board[i][j]='O';
                }
            }
        }    
    }

    public void dfs(char[][] board, int i, int j, boolean[][] vis){
        board[i][j] = 'Y';
        vis[i][j] = true;
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] dir : directions){
            int nr = dir[0]+i;
            int nc = dir[1]+j;
            if(nr>=0 && nc>=0 && nr<rows && nc<cols 
                && board[nr][nc] == 'O' ){
                    dfs(board, nr, nc, vis);
                
            }
        }
    }
}
