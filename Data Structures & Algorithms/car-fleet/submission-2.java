class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int[][] pair = new int[position.length][2];

        for(int i=0; i<position.length; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a,b) -> Integer.compare(b[0],a[0]));
        Deque<int[]> stack = new ArrayDeque<>();
        for(int i=0; i<pair.length; i++){
            
            if(stack.isEmpty()){
                stack.push(pair[i]);
                continue;
            }

            float topTime = (target-stack.peek()[0])/(float)stack.peek()[1];
            float currTime = (target-pair[i][0])/(float)pair[i][1];
            if(currTime > topTime){
                stack.push(pair[i]);
            }
        }


        return stack.size();
    }
}
