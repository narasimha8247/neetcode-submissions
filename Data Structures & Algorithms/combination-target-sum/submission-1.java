class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        cs(nums, target, 0, new ArrayList<>());
        return res;
    }

    public void cs(int[] nums, int rem, int start, List<Integer> li){
        if(rem==0){
            res.add(new ArrayList<>(li));
        }

        for(int i=start; i<nums.length; i++){
            if(rem>=nums[i]){
                li.add(nums[i]);
                cs(nums, rem-nums[i], i, li);
                li.remove(li.size()-1);
            }
        }
    }
}
