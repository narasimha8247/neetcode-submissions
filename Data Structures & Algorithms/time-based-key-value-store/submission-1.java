class TimeMap {

    class Pair{
        int timestamp;
        String value;
        Pair(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        map.computeIfAbsent(key, k -> new ArrayList<>())
            .add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
       if(!map.containsKey(key)){
        return "";
       }

       List<Pair> pairs = map.get(key);
       // all the timestamp in pairs is sorted 
       int left = 0;
       int right = pairs.size()-1;

       while(left<=right){
            int middle = left + (right-left)/2;
            if(pairs.get(middle).timestamp==timestamp){
                return pairs.get(middle).value;
            }else if(pairs.get(middle).timestamp < timestamp){
                left = middle + 1;
            }else{
                right = middle - 1;
            }
       }

       return right>=0 ? pairs.get(right).value : "";
    }
}
