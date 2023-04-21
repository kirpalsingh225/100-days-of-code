import java.util.*;
public class day21 {
    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> graph = buildGraph(bombs);
        
        int ans = 1;
        for(int i=0;i<bombs.length;i++){
            int count = 0;
            HashSet<Integer> visited = new HashSet<>();
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            visited.add(i);
            while(!q.isEmpty()){
                int temp = q.poll();
                for(int v : graph.get(temp)){
                    if(!visited.contains(v)){
                        visited.add(v);
                        q.offer(v);
                    }
                }
            }
            ans = Math.max(ans, visited.size());
        }
        return ans;
    }


    Map<Integer, List<Integer>> buildGraph(int[][] bombs){
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i=0;i<bombs.length;i++){
            List<Integer> adj = new ArrayList<>();
                long x = bombs[i][0];
                long y = bombs[i][1];
                long r = bombs[i][2];
            for(int j=0;j<bombs.length;j++){
                long x1 = bombs[j][0];
                long y1 = bombs[j][1];

                if(i!=j){
                    if((x-x1)*(x-x1)+(y-y1)*(y-y1)<=r*r){
                        adj.add(j);
                    }
                }
            }
            graph.put(i, adj);
        }
        return graph;
    }
}
