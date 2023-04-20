import java.util.*;
public class day20 {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] d1 = new int[n];
        int[] d2 = new int[n];

        Arrays.fill(d1, Integer.MAX_VALUE);
        Arrays.fill(d2, Integer.MAX_VALUE);

        bfs(edges, node1, d1);
        bfs(edges, node2, d2);

        int mindisnode = -1;
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int maxdistcurr = Math.max(d1[i], d2[i]);
            if (maxdistcurr < minDist) {
                minDist = maxdistcurr;
                mindisnode = i;
            }
        }

        return mindisnode;
        
    }


    void bfs(int[] edges, int curr, int[] dist){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[edges.length];
        visited[curr] = true;
        dist[curr] = 0;
        q.offer(curr);

        while(!q.isEmpty()){
            int temp = q.poll();
            int adj = edges[temp];
            if(adj!=-1 && !visited[adj]){
                visited[adj] = true;
                dist[adj] = dist[temp]+1;
                q.offer(adj);
            }
        }
    }
}
