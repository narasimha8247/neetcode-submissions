class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        p1(nums, visited, new ArrayList<>());
        return res;
    }

    public void p1(int[] nums, boolean[] visited, List<Integer> li){
        if(li.size()==nums.length){
            res.add(new ArrayList<>(li));
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            li.add(nums[i]);
            p1(nums, visited, li);
            li.remove(li.size()-1);
            visited[i] = false;
        }
        
        
    }
}
