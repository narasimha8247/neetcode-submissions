class Solution {
    int rows;
    int cols;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                boolean[][] vis = new boolean[rows][cols];
                boolean res = va(board, word, 0, i, j, vis);
                if(res){
                    return res;
                }
            }
        }
        return false;
        
    }

    public boolean va(char[][] board, String word, int i, int ri, int ci, boolean[][] vis){
        if(i==word.length()){
            return true;
        }

        if(ri<0 || ci<0 || ri>=rows || ci>=cols){
            return false;
        }
        
        if(vis[ri][ci] || board[ri][ci]!=word.charAt(i)){
            return false;
        }
        vis[ri][ci] = true;
        boolean found = va(board, word, i+1, ri+1, ci, vis) ||
        va(board, word, i+1, ri-1, ci, vis) ||
        va(board, word, i+1, ri, ci+1, vis) ||
        va(board, word, i+1, ri, ci-1, vis);
        vis[ri][ci] = false;
        return found;
    }
}
