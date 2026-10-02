class Solution {
    public boolean hasDuplicate(int[] nums) {
        
        Set<Integer> hashSet = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(!hashSet.add(nums[i])){
                return true;
            }
        }

        return false;
    }
}