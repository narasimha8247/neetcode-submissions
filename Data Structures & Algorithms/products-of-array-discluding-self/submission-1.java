class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] ret = new int[nums.length];
        int prod = Arrays.stream(nums)
                .filter(x -> x!=0)
                .reduce((x,y) -> x*y)
                .orElse(1);
        boolean isZeroPresent = false;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                count++;
                isZeroPresent = true;
            }
        }


        for(int i=0; i<nums.length; i++){
            if(isZeroPresent){
                if(count > 1){
                    ret[i] = 0;
                }else{
                    ret[i] = nums[i]==0 ? prod : 0;
                }
                
            }else{
                ret[i] = prod/nums[i];
            }
        }
        return ret;
    }
}  
