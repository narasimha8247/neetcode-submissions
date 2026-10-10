class Solution {
    public int findDuplicate(int[] nums) {
        
        // slow and fast approach
        int slow = 0;
        int fast = 0;

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);

        int pointer = 0;
        while(pointer!=slow){
            slow = nums[slow];
            pointer = nums[pointer];
        }

        return pointer;
    }
}
