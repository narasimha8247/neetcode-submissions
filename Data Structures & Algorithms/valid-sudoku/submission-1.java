class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Map<Integer, HashSet<Character>> rowMap = new HashMap<>();
        Map<Integer, HashSet<Character>> colMap = new HashMap<>();
        Map<Integer, HashSet<Character>> squareMap = new HashMap<>();
        // check row wise
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(rowMap.get(i)==null){
                    rowMap.put(i, new HashSet());
                }
                if(colMap.get(j)==null){
                    colMap.put(j, new HashSet());
                }
                // calculation for square
                int sqNo = (i/3) * 3 + (j/3) * 1; 
                if(squareMap.get(sqNo)==null){
                    squareMap.put(sqNo, new HashSet());
                }
                if(!rowMap.get(i).add(board[i][j]) || 
                        !colMap.get(j).add(board[i][j]) || 
                        !squareMap.get(sqNo).add(board[i][j])){
                    return false;
                }
            }
        }
        return true;

    }
}
