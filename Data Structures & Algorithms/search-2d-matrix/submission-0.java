class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m*n-1;
        while(left<=right){
            int middle = left + (right-left)/2;
            
            int row = middle/n;
            int col = middle%n;
            int val = matrix[row][col];
            if(val < target){
                left = middle + 1;
            }else if(val > target){
                right = middle - 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
