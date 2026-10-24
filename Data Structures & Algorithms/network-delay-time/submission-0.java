class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Edge>> graph = new HashMap<>();

        for(int i=0; i<=n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge : times){
            graph.get(edge[0]).add(new Edge(edge[1], edge[2]));
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        minHeap.offer(new int[]{k,0});

        Map<Integer, Integer> sp = new HashMap<>();
        while(!minHeap.isEmpty()){
            // get the top one
            int[] topEdge = minHeap.poll();
            if(!sp.containsKey(topEdge[0])){
                sp.put(topEdge[0], topEdge[1]);
            }else{
                continue;
            }
            // iterate through all neighbours
            for(Edge edge : graph.get(topEdge[0])){
                minHeap.offer(new int[]{edge.edge, topEdge[1]+edge.time});
            }
        }

        if(sp.size()!=n){
            return -1;
        }

        int max = Integer.MIN_VALUE;
        for(int ii : sp.values()){
            max = Math.max(max, ii);
        }

        return max;
        
    }

    

    class Edge{
        int edge;
        int time;
        Edge(int e, int t){
            edge = e;
            time = t;
        }
    }
}
