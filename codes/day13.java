import java.util.*;
public class day13 {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> g = new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int[] edges : paths){
            g.get(edges[0]-1).add(edges[1]-1);
            g.get(edges[1]-1).add(edges[0]-1);
        }
        int[] color = new int[n];

        for(int i=0;i<n;i++){
            if(color[i]==0){
                color[i] = 1;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                while(!q.isEmpty()){
                    int curr = q.poll();
                    for(int v : g.get(curr)){
                        if(color[v]==0 || color[v]==color[curr]){
                            color[v] = color[curr]+1;
                            q.offer(v);
                        }
                        if(color[v]>4){
                            color[v]%=4;
                        }
                    }
                }
            }
        }

        return color;
    }
}
