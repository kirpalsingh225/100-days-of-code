import java.util.*;
public class day2 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList();
        curr.add(0);
        dfs(graph , res , curr , graph.length-1, 0);
        return res;
    }
    void dfs(int[][] graph, List<List<Integer>> res, List<Integer> curr, int dest, int src){
        if(src==dest){
            res.add(new ArrayList(curr));
        }
        else{
            for(int v : graph[src]){
                curr.add(v);
                dfs(graph, res, curr, dest, v);
                curr.remove(curr.size()-1);
            }
        }
        
    }
}
