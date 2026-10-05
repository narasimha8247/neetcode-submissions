class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Set<List<Integer>> ret = new HashSet<>();

        // sort the array
        Arrays.sort(nums);
        int target = 0;
        for(int i=0; i<nums.length; i++){
            int secondTarget = target - nums[i];
            List<Integer> li = new ArrayList<>();
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[left]+nums[right];
                if(sum > secondTarget){
                    right--;
                }else if(sum < secondTarget){
                    left++;
                }else{
                    li.add(nums[i]); li.add(nums[left]); li.add(nums[right]);
                    left++;
                    if(!li.isEmpty())
                        ret.add(li);
                    li = new ArrayList<>();
                }
            }
            
        }

        return new ArrayList<>(ret);
    }
}
