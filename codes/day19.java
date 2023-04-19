public class day19 {
    public int edgeScore(int[] edges) {
        long[] indegree = new long[edges.length];

        for(int i=0;i<edges.length;i++){
            indegree[edges[i]]+=i;
        }

        int ans = 0;
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]>indegree[ans]){
                ans = i;
            }
        }
        return ans;
    }

}
