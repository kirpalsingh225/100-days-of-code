import java.util.*;
public class day30 {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->{
                return a[2]-b[2];
            }
        );
        int[][] dist = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        dist[0][0]=0;
        pq.offer(new int[]{0, 0, 0});

        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int x = temp[0];
            int y = temp[1];
            int cost = temp[2];

            for(int i=0;i<4;i++){
                int adjx = x + directions[i][0];
                int adjy = y + directions[i][1];

                if(valid(adjx, adjy, m, n)){
                    if(grid[x][y]!=i+1){
                        if(1 + dist[x][y] < dist[adjx][adjy]){
                            dist[adjx][adjy] = 1 + dist[x][y];
                            pq.offer(new int[]{adjx, adjy, dist[adjx][adjy]});
                        }
                    }
                    else{
                        if(dist[x][y] < dist[adjx][adjy]){
                            dist[adjx][adjy] = dist[x][y];
                            pq.offer(new int[]{adjx, adjy, dist[adjx][adjy]});
                        }
                    }
                }
            }
           
        }
        return dist[m-1][n-1];
    }

    boolean valid(int x, int y, int m, int n){
        if(x < 0 || y < 0 || x >= m || y >= n){
            return false;
        }
        return true;
    }

    
}

