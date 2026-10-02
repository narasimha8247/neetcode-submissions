class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] ret = new int[nums.length];
        ret[nums.length-1] = nums[nums.length-1];

        // product from right
        for(int i=nums.length-2; i>0; i--){
            ret[i] = ret[i+1] * nums[i];
        }

        int leftProduct = 1;
        for(int i=0; i<nums.length-1; i++){
            ret[i] = ret[i+1] * leftProduct;
            leftProduct = leftProduct * nums[i];
        }

        ret[nums.length-1] = leftProduct;
        return ret;
    }
}  
