class Solution {

    Map<Integer, Integer> par = new HashMap<>();
    Map<Integer, Integer> rank = new HashMap<>();

    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;
        for(int i=1; i<=n; i++){
            par.put(i,i);
            rank.put(i,0);
        }

        for(int[] edge : edges){
            boolean uni = union(edge[0], edge[1]);
            if(!uni){
                return edge;
            }
        }
        return new int[0];
    }

    // union find
    public int find(int n){
        
        while(n != par.get(n)){
            par.put(n, par.get(par.get(n)));
            n = par.get(n);
        }
        return n;
    }

    // union
    public boolean union(int u, int v){
        int p1 = find(u);
        int p2 = find(v);
        // both parents are same then there is loop
        if(p1==p2){
            return false;
        }
        int r1 = rank.get(p1);
        int r2 = rank.get(p2);
        if(r1>r2){
            par.put(p2,p1);
        }else if(r2>r1){
            par.put(p1,p2);
        }else{
            par.put(p2,p1);
            rank.put(p1, rank.get(p1)+1);
        }
        return true;
    }
}
