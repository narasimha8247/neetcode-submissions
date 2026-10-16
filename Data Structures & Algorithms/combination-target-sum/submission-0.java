class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        cs(nums, target, new ArrayList<>(), 0);
        return res;
    }

    public void cs(int[] nums, int target, List<Integer> li, int start){
        if(target==0){
            res.add(new ArrayList<>(li));
            return;
        }

        for(int i=start; i<nums.length; i++){
            if(target-nums[i]>=0){
                li.add(nums[i]);
                cs(nums, target-nums[i], li, i);
                li.remove(li.size()-1);
            }
        }
    }
}
