class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        ss(nums, 0, new ArrayList<>());
        return res;
    }

    public void ss(int[] nums, int i, List<Integer> li){
        
        if(i>=nums.length){
            res.add(new ArrayList<>(li));
            return;
        }
        li.add(nums[i]);
        ss(nums, i+1, li);
        li.remove(li.size()-1);
        ss(nums, i+1, li);
    }
}
