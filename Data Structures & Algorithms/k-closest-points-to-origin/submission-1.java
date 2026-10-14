class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (x,y) -> Integer.compare(y[0]*y[0]+y[1]*y[1],x[0]*x[0]+x[1]*x[1]));
        for(int[] point: points){
            if(pq.size()==k){
                int curPointLen = point[0]*point[0] + point[1]*point[1];
                int[] topEle = pq.peek();
                int topEleLen = topEle[0]*topEle[0] + topEle[1]*topEle[1];
                if(topEleLen>curPointLen){
                    pq.poll();
                    pq.offer(point);
                }
            }else{
                pq.offer(point);
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
