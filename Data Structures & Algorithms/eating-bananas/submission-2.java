class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxBound = Integer.MIN_VALUE;
        for(int i=0; i<piles.length; i++){
            maxBound = Math.max(maxBound,piles[i]);
        }

        int left = 1;
        int right = maxBound;
        int lowest = maxBound;
        while(left<=right){
            int middle = left + (right-left)/2;
            // get h for this middle
            int midh = 0;
            for(int i=0; i<piles.length; i++){
                midh = midh + (piles[i]+middle-1)/middle;
            }

            if(midh > h){
                left = middle + 1;
            }else if(midh < h){
                right = middle - 1;
                lowest = Math.min(lowest, middle);
            }else{
                lowest = Math.min(lowest, middle);
                right = middle - 1;
            }
        }
        return lowest;

    }
}
