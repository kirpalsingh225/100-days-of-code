import java.util.*;
public class day24 {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (a[2]-b[2]));
        Set<Integer> visited = new HashSet<>();

        int cost = 0;
        pq.offer(new int[]{0, 0, 0});

        while(!pq.isEmpty()){
            int[] res = pq.poll();
            int end = res[1];
            int weight = res[2];

            if(visited.contains(end)) continue;

            cost+=weight;
            visited.add(end);
            for(int i=0;i<points.length;i++){
                if(!visited.contains(i)){
                    pq.offer(new int[]{end, i, distance(points, end, i)});
                }
            }
        }
        return cost;
    }

    int distance(int[][] points, int i, int j){
        return Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
    }
}
