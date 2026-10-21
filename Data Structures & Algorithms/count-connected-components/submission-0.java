class Solution {
    public int countComponents(int n, int[][] edges) {
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
        int count=0;
        for (int i = 0; i < n; i++) {
            if(!vis[i]){
                count++;
                dfs(i, -1, graph, vis);
            }
        }
        return count;
    }

    public void dfs(int cur, int parent, Map<Integer, List<Integer>> graph, boolean[] vis) {
        if (vis[cur]) {
            return;
        }
        vis[cur] = true;
        for (int child : graph.get(cur)) {
            if (child == parent) {
                continue;
            }
            dfs(child, cur, graph, vis);
        }
        
    }
}
