class KthLargest {

    private PriorityQueue<Integer> minHeap;
    int required;
    
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        required = k;
        for(int i=0; i<nums.length; i++){
            add(nums[i]);
            
        }
        
    }
    
    public int add(int val) {
        minHeap.offer(val);

        if(minHeap.size() > required){
            minHeap.poll();
        }

        return minHeap.peek();
    }

    
}
