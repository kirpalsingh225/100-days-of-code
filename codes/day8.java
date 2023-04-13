public class day8 {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int val = 0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i]){
                continue;
            }
            else{
                val++;
                dfs(i, visited, stones, n);
            }
        }
        return n-val;
    }

    public void dfs(int idx, boolean[] visited, int[][] stones, int n){
        visited[idx]=true;
        for(int i=0;i<n;i++){
            if(visited[i]==true){
                continue;
            }
            
            if(stones[idx][0]==stones[i][0] || stones[idx][1]==stones[i][1]){
                dfs(i, visited, stones, n);
            }
            
        }
    }
}
