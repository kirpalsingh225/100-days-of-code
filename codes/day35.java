import java.util.*;
public class day35 {
    LinkedList<Integer> adj[];
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        makeadj(edges,n);
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            visited[i] = false;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int i:adj[temp]){
                if(visited[i]!=true){
                    visited[i]=true;
                    queue.offer(i);
                }
            }
        }
        return visited[destination];
        
        
    }
    
    void makeadj( int[][] edges, int n){
        adj = new LinkedList[n];
        for(int i=0;i<n;i++){
            adj[i] = new LinkedList<>();
        }
        int u,v;
        for(int j=0;j<edges.length;j++){
            u = edges[j][0];
            v = edges[j][1];
            
            adj[u].add(v);
            adj[v].add(u);
        }
        
        
        
    }
}
