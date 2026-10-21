class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> cmap = new HashMap<>();
        for(int i=0; i<numCourses; i++){
            cmap.put(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            cmap.get(pre[0]).add(pre[1]);
        }

        int[] vis = new int[numCourses];
        List<Integer> order = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            if(vis[i]==0){
                if(cycle(i, cmap, vis, order)){
                    return new int[0];
                }
            }
        }
        int[] out = new int[order.size()];
        for(int i=0; i<order.size(); i++){
            out[i] = order.get(i);
        }

        return out;

    }

    public boolean cycle(int course, Map<Integer, 
        List<Integer>> cmap, 
        int[] vis, 
        List<Integer> res){

        if(vis[course] == 1) return true;
        if(vis[course] == 2) return false;

        vis[course] = 1;
        for(int dep : cmap.get(course)){
            if(cycle(dep, cmap, vis, res)){
                return true;
            }
        }
        vis[course] = 2;
        res.add(course);
        return false;
    }


}
