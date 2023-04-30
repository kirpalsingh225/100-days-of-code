import java.util.*;
public class day31 {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int target_mask = (1<<n) - 1 ;

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            int mask = (1<<i);
            q.offer(new int[]{i,mask});
        }
        int[][] visited = new int[n][target_mask+1];

        int ans = 0;

        while(!q.isEmpty()){
            ans++;
            int size = q.size();
            while(size-->0){
                int[] temp = q.poll();
                int curr = temp[0];
                int m = temp[1];

                for(int neighbor : graph[curr]){
                    int newmask = (m | (1<<neighbor));

                    if(visited[neighbor][newmask]==1){
                        continue;
                    }
                    if(newmask==target_mask){
                        return ans;
                    }
                    visited[neighbor][newmask]=1;
                    q.add(new int[]{neighbor, newmask});
                }
            }
        }
        return 0;
    }
}
