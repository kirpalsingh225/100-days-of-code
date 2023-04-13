public class day9 {
    public int maximalNetworkRank(int n, int[][] roads) {
        int rank = 0;
        int[] indegree = new int[n];
        int[][] neighbor = new int[n][n];
        for(int i=0;i<roads.length;i++){
            int start = roads[i][0];
            int end = roads[i][1];
            neighbor[start][end]=1;
            neighbor[end][start]=1;
            indegree[start]++;
            indegree[end]++;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                rank = Math.max(rank, indegree[i]+indegree[j]-neighbor[i][j]);
            }
        }
        return rank;

    }
}
