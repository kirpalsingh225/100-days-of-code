class day23{
    public int findJudge(int n, int[][] trust) {
        if(n==1 && trust.length==0){
            return n;
        }
        int[] outdegree = new int[n+1];
        int[] indegree = new int[n+1];
        for(int i=0;i<outdegree.length;i++){
            outdegree[i]=0;
            indegree[i]=0;
        }
        for(int i=0;i<trust.length;i++){
            int x = trust[i][0];
            outdegree[x]++;
            int y = trust[i][1];
            indegree[y]++;
        }
        
        for(int j=0;j<outdegree.length;j++){
            int d = indegree[j]-outdegree[j];
            if(d==n-1){
                return j;
            }
        }
        return -1;
    }
}