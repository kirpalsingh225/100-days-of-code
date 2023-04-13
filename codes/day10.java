public class day10 {
    public int minScore(int n, int[][] roads) {
        int[] p = new int[n+1];
        int[] rank = new int[n+1];
        for(int i=0;i<n;i++){
            p[i]=i;
        }
        for(int i=0;i<roads.length;i++){
            union(roads[i][0]-1, roads[i][1]-1, p, rank);
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<roads.length;i++){
            if(find(roads[i][0]-1,p)==find(0,p) && find(roads[i][0]-1,p)==find(roads[i][1]-1,p)){
                ans = Math.min(ans, roads[i][2]);
            }
        }
        return ans;
    }

    int find(int x, int[] p){
        if(p[x]==x) return x;
        return find(p[x], p);
    }
    
    void union(int a, int b, int[] p, int[] rank){
        int x = find(a, p);
        int y = find(b, p);

        if(x==y){
            return;
        }
        if(rank[x]<rank[y]){
            p[x]=y;
        }
        else if(rank[x]>rank[y]){
            p[y]=x;
        }
        else{
            p[y]=x;
            rank[x] = rank[x]+1;
        }
    }
}
