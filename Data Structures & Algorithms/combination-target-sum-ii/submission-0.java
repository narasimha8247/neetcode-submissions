class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        cs2(candidates, target, new ArrayList<>(), 0);
        return res;
    }

    public void cs2(int[] cd, int rem, List<Integer> li, int start){
        if(rem==0){
            res.add(new ArrayList<>(li));
            return;
        }
        
        for(int i=start; i<cd.length; i++){
            if(i>start && cd[i]==cd[i-1]){
                continue;
            }
            if(rem>=cd[i]){
                li.add(cd[i]);
                cs2(cd, rem-cd[i], li, i+1);
                li.remove(li.size()-1);
            }
        }
        
    }
}
