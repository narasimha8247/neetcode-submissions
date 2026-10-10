class LRUCache {
    Map<Integer, ListNode> map;
    int capacity;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new ListNode(0,0); //dummy
        tail = new ListNode(0,0); // dummy
        head.next =  tail;
        tail.previous = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        ListNode li = map.get(key);
        remove(li);
        updateTail(li);

        return li.val;
    }

    public void put(int key, int value) {

        if(map.containsKey(key)){
            // update LRU
            ListNode li = map.get(key);
            li.val = value;
            remove(li);
            updateTail(li);
            return;
        }

        if(map.size() == capacity){
            // remove the LRU one that is head
            map.remove(head.next.key);
            remove(head.next);
        }
        ListNode li = new ListNode(key, value);
        map.put(key, li);
        // new one is added - we can add to tail as this is used MRU
        updateTail(li);

    }

    private void updateTail(ListNode li){
        ListNode prev = tail.previous;
        prev.next = li;
        li.previous = prev;
        li.next = tail;
        tail.previous = li;
    }

    private void remove(ListNode li){
        li.next.previous = li.previous;
        li.previous.next=li.next;
    }

    class ListNode {
        int val;
        int key;
        ListNode next;
        ListNode previous;
        ListNode(int key, int val) {
            this.val = val;
            this.key = key;
            next = null;
            previous = null;
        }
    }
}
