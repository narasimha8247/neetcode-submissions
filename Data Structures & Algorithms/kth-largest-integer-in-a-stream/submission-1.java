class KthLargest {

    List<Integer> heap;
    int k;
    
    public KthLargest(int k, int[] nums) {
        heap = new ArrayList<>();
        heap.add(0); //add dummy
        this.k = k;
        for(int i=0; i<nums.length; i++){
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        if(heap.size()-1 < k){
            // we haven't reached capacity yet
            heap.add(val);
            heapifyUp();
        }else if(val > heap.get(1)){
            heap.set(1, val);
            heapifyDown();
        }
        
        return heap.get(1);
    }

    private void heapifyUp(){
        int size = heap.size()-1;
        while((size/2) > 0){
            int cur = heap.get(size);
            int parentIdx = size/2;
            int parent = heap.get(parentIdx);
            if(parent > cur){
                heap.set(size, parent);
                heap.set(parentIdx, cur);
            }else{
                break;
            }
            size = size/2;
        }
    }

    private void heapifyDown(){
        int size = heap.size()-1;
        int i = 1;
        while(2*i <= size){
            int leftChild = 2*i;
            int rightChild = 2*i + 1;
            int smallest = i;

            if(leftChild<=size && heap.get(leftChild) < heap.get(smallest)){
                smallest = leftChild;
            }

            if(rightChild<=size && heap.get(rightChild) < heap.get(smallest)){
                smallest = rightChild;
            }

            // if current node already smallest, then done
            if(i!=smallest){
                int temp = heap.get(smallest);
                heap.set(smallest, heap.get(i));
                heap.set(i,temp);
                i = smallest;
            }else{
                break;
            }
        }
    }

    
}
