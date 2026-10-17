class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ss2(nums, 0, new ArrayList<>());
        return res;
    }

    public void ss2(int[] nums, int start, List<Integer> li){
        res.add(new ArrayList<>(li));

        for(int i=start; i<nums.length; i++){
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            li.add(nums[i]);
            ss2(nums, i+1, li);
            li.remove(li.size()-1);
        }
    }
}
