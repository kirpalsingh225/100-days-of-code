public class day25 {
    public int findCenter(int[][] edges) {
        int n=0;
        int ans=0;
        for(int i=0;i<edges.length;i++){
            n = Math.max(n,Math.max(edges[i][0],edges[i][1]));
        }
        
        int[] indegree = new int[n+1];
        for(int j=0;j<edges.length;j++){
            
            indegree[edges[j][0]]++;
            
            indegree[edges[j][1]]++;
        }
        
        for(int k=0;k<indegree.length;k++){
            if(indegree[k]==n-1){
                ans = k;
                break;
            }
        }
        return ans;
    }
}
