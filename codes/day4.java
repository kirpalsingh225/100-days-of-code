import java.util.*;
public class day4 {
    public int minReorder(int n, int[][] connections) {
        Map<Integer,Integer> m = new HashMap<>();
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        int count = 0;

        for(int i=0;i<n;i++){
            g.add(new ArrayList());
        }

        for(int i=0;i<connections.length;i++){
            int start = connections[i][0];
            int end = connections[i][1];
            m.put(start,end);
            g.get(start).add(end);
            g.get(end).add(-start);
            
        }

        queue.add(0);
        visited[0]=true;
        while(!queue.isEmpty()){
            int prev = queue.poll();
            for(int x : g.get(Math.abs(prev))){
                if(!visited[Math.abs(x)]){
                    visited[Math.abs(x)]=true;
                    queue.offer(Math.abs(x));
                    if(x>0){
                        count++;
                        
                    }
                    
                }
            }

        }
        return count;

    }
}
