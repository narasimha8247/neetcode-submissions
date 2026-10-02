class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        // bucket list approach
        List<Integer>[] buckList = new List[nums.length+1];

        for(Map.Entry<Integer, Integer> entrySet : map.entrySet()){
            if(buckList[entrySet.getValue()] == null)
                buckList[entrySet.getValue()] = new ArrayList<>();
            buckList[entrySet.getValue()].add(entrySet.getKey());
        }

        int[] ret = new int[k];
        int elements = 0;
        for(int i=nums.length; i>=0 && elements < k; i--){
            List<Integer> li = buckList[i];
            if(li!=null){
                for(int ii : li){
                    ret[elements++] = ii;
                    if(elements == k){
                        break;
                    }
                }
            }
        }
        return ret;

        
    }
}
