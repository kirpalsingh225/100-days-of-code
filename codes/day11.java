import java.util.*;
public class day11 {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];

        for(int i=0;i<graph.length;i++){
            if(color[i]==0){
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i]=1;
                while(!q.isEmpty()){
                    int temp = q.poll();
                    for(int v : graph[temp]){
                        if(color[v]==color[temp]) return false;
                        else if(color[v]==0){
                            q.add(v);
                            color[v] = -color[temp];
                        }
                    }
                }
            }
        }
        return true;
    }
}
