class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int stone : stones){
            maxHeap.offer(stone);
        }

        while(maxHeap.size()>1){
            int firstMax = maxHeap.poll();
            int secondMax = maxHeap.poll();

            int res = Math.abs(firstMax-secondMax);
            if(res!=0){
                maxHeap.offer(res);
            }
        }

        return maxHeap.size()==0 ? 0 : maxHeap.poll();

    }
}
