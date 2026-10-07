class Solution {
    public int findMin(int[] nums) {
        
        int left = 0;
        int right = nums.length-1;
        int min = Integer.MAX_VALUE;

        while(left<=right){
            int middle = left + (right-left)/2;

            // increasing
            if(nums[left] < nums[middle] && nums[middle] > nums[right]){
                left = middle + 1;
            }else if(nums[left] > nums[middle] && nums[middle] < nums[right]){
                right = middle -1;
            }else if (nums[left] > nums[middle] && nums[middle] > nums[right]){
                left = middle + 1;
            }else if (nums[left] < nums[middle] && nums[middle] < nums[right]){
                right = middle - 1;
            }else{
                left = middle + 1;
            }
            min = Math.min(min, nums[middle]);
        }
        return min;
    }
}
