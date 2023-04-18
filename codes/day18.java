import java.util.*;
public class day18 {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
            ans.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int start = edges[i][0];
            int end = edges[i][1];
            graph.get(start).add(end);
        }

        for(int i=0;i<n;i++){
            boolean[] visited = new boolean[n];
            dfs(i, visited, graph);
            for(int j=0;j<visited.length;j++){
                if(i==j) continue;
                if(visited[j]){
                    ans.get(j).add(i);
                }
            } 
        }
        
        return ans;
    }

    void dfs(int src, boolean[] visited, List<List<Integer>> graph){
        visited[src]=true;
        for(int v : graph.get(src)){
            if(!visited[v]){
                dfs(v, visited, graph);
            }                       
        }
    }
}
