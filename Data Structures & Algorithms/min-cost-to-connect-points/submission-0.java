class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;
        // int[] -> {index(basically point), distance}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);

        pq.offer(new int[]{0,0});
        boolean[] vis = new boolean[n];
        int distance = 0;
        while(!pq.isEmpty()){
            int[] pd = pq.poll();
            int u = pd[0];

            if(vis[u]){
                continue;
            }
            vis[u] = true;
            distance+=pd[1];

            for(int i=0; i<n; i++){
                if(!vis[i]){
                    int dis = Math.abs(points[u][0]-points[i][0]) + Math.abs(points[u][1]-points[i][1]);
                    pq.offer(new int[]{i,dis});
                }
            }
        }
        return distance;
    }
}
