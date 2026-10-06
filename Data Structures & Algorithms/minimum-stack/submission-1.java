class MinStack {

    List<Integer> li;
    int size;
    Map<Integer, Integer> minMap;
    int min;

    public MinStack() {
        li = new ArrayList<>();
        size = 0;
        min = Integer.MAX_VALUE;
        minMap = new HashMap<>();
    }
    
    public void push(int val) {
        li.add(val);
        min = Math.min(min,val);
        minMap.put(size,min);
        size++;
    }
    
    public void pop() {
        int removed = li.remove(size-1);
        minMap.remove(size-1);
        size--;
        if(size > 0){
            min = minMap.get(size-1);
        }else{
            min = Integer.MAX_VALUE;
        }
        
    }
    
    public int top() {
        return li.get(size-1);
    }
    
    public int getMin() {
        return min;
    }
}
