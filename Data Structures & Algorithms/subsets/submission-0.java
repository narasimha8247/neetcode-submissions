class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        ss(nums, 0, new ArrayList<>());
        return res;
    }

    public void ss(int[] nums, int i, List<Integer> li){
        
        if(i>=nums.length){
            res.add(li);
            return;
        }
        List<Integer> newLi = new ArrayList<>(li);
        ss(nums, i+1, li);
        newLi.add(nums[i]);
        ss(nums, i+1, newLi);
    }
}
