class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        // let's have pair with task and count and add it into heap
        int[] counting = new int[26];
        for(char c : tasks){
            counting[c-'A']++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (x,y) -> Integer.compare(y.count, x.count));

        // blocked priority queue
        Queue<BTask> cdq = new ArrayDeque<>();

        for(int i=0; i<26; i++){
            if(counting[i]>0)
                pq.offer(new Pair((char) (i+'A'), counting[i]));
        }

        // Now pq has elements in order to process
        int process = 0;

        while(!pq.isEmpty() || !cdq.isEmpty()){
            process++;

            // if anything from cooldown ready to comeback we will add to max-heap
            if(!cdq.isEmpty() && cdq.peek().availableTime==process){
                BTask btask = cdq.poll();
                pq.offer(new Pair(btask.task, btask.remainingCount));
            }

            if(!pq.isEmpty()){
                Pair pair = pq.poll();
                pair.count--;
                if(pair.count>0){
                    cdq.offer(new BTask(pair.task, pair.count, process+n+1));
                }
            }

        }

        return process;

    }

    class Pair{
        char task;
        int count;
        Pair(char t, int c){
            task = t;
            count = c;
        }
    }

    class BTask{
        char task;
        int remainingCount;
        int availableTime;
        BTask(char t, int r, int a){
            task = t;
            remainingCount = r;
            availableTime = a;
        }
    }
}
