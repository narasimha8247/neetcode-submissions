class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int secondOne = target - nums[i];
            if(map.containsKey(secondOne)){
                return new int[]{map.get(secondOne),i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0,0};
    }
}
