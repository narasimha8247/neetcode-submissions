class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (x,y) -> Integer.compare(y[0]*y[0]+y[1]*y[1],x[0]*x[0]+x[1]*x[1]));
        for(int[] point: points){
            pq.offer(point);
            if(pq.size()>k){
                pq.poll();
            }
            
        }
        int[][] out = new int[k][2];
        int i=0;
        while(!pq.isEmpty()){
            int[] max = pq.poll();
            out[i][0] = max[0];
            out[i][1] = max[1];
            i++;
        }

        return out;

    }
}
