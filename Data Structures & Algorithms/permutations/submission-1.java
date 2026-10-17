class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        p1(nums,new ArrayList<>(), vis);
        return res;
    }

    public void p1(int[] nums, List<Integer> li, boolean[] vis){
        if(li.size()==nums.length){
            res.add(new ArrayList<>(li));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(vis[i]){
                continue;
            }
            vis[i] = true;
            li.add(nums[i]);
            p1(nums, li, vis);
            vis[i] = false;
            li.remove(li.size()-1);
        }
    }

    
}
