class Solution {
    boolean[] canTake;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        canTake = new boolean[numCourses];
        // let's build some graph
        Map<Integer, List<Integer>> cmap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            cmap.put(i, new ArrayList<>());
        }
        for (int[] crs : prerequisites) {
            cmap.get(crs[0]).add(crs[1]);
        }
        int[] vis = new int[numCourses];
        for (int i=0; i<numCourses; i++) {
            if(vis[i]==0){
                if(ctc(i, cmap, vis)){
                    return false;
                }
            }
            
        }
        return true;
    }

    public boolean ctc(int course, Map<Integer, List<Integer>> cmap, int[] vis) {
        
        
        if (vis[course]==1) {
            return true;
        } else if (vis[course]==2) {
            return false;
        } else {
            vis[course] = 1;
            for(int dep : cmap.get(course)){
                if(ctc(dep, cmap, vis)){
                    return true;
                }
            }
            vis[course] = 2;
            return false;
        }


    }
}
