import java.util.*;
public class day15 {
    class node{
        int target;
        int distance;

        public node(int target, int distance){
            this.target = target;
            this.distance = distance;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<node>> graph = new HashMap<>();
        for(int i=1;i<=n;i++){
            graph.put(i, new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int start = times[i][0];
            int end = times[i][1];
            int weight = times[i][2];
            graph.get(start).add(new node(end, weight));
        }
        Queue<node> q = new LinkedList<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        q.offer(new node(k, 0));
        dist[k] = 0;
        int time = 0;
        while(!q.isEmpty()){
            node temp = q.poll();
            for(node x : graph.get(temp.target)){
                    int v = x.target;
                    int w = x.distance;
                
                    if(dist[temp.target]+w < dist[v]){
                        q.offer(x);
                        dist[v] = dist[temp.target]+w;
                    }
                
            }
        }
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            time = Math.max(time, dist[i]);
        }
        return time;
    }
}
