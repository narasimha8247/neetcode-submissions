class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // is checking cycle fine
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // detect cycle now
        boolean[] vis = new boolean[n];
        // since for tree, DFS will go through all the nodes;
        if(isCycle(0,-1,graph,vis)){
            return false;
        }

        for(int i=0; i<n; i++){
            if(!vis[i]){
                return false;
            }
        }
        return true;
    }

    public boolean isCycle(int cur, int parent, Map<Integer, 
                List<Integer>> graph, boolean[] vis) 
    {
        
        if(vis[cur]){
            return true;
        }
        vis[cur]=true;
        for(int child : graph.get(cur)){
            if(child==parent){
                continue;
            }
            if(isCycle(child,cur,graph,vis)){
                return true;
            }
        }
        return false;

    }
}
