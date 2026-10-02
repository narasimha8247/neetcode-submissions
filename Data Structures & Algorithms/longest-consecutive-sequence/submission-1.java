class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int max = 0;
        for(int num : nums){
            int localMax = 1;
            // forward
            int start = num;
            while(set.contains(start+1)){
                set.remove(start+1);
                localMax++;
                start++;
            }
            // backward
            start = num;
            while(set.contains(start-1)){
                set.remove(start-1);
                localMax++;
                start--;
            }
            max = Math.max(max,localMax);
        }

        return max;
    }
}
