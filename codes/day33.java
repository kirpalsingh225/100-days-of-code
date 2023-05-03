import java.util.*;
public class day33 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] cities = new int[n][n];
        int inf = (int)1e9+7;
            
        for(int i=0;i<n;i++){
            Arrays.fill(cities[i] , inf);
            cities[i][i] = 0;
        }
            
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            cities[u][v] = w;
            cities[v][u] = w;
        }
            
        floyd_warshwall(n , cities);
          
        int mincitycount = n;
        int mincity = -1;
        for(int i=0;i<n;i++){
            int curcitycount = 0;
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                if(cities[i][j]<=distanceThreshold){
                    curcitycount++;
                }
            }
            if(mincitycount >= curcitycount){
                mincitycount = curcitycount;
                mincity = i;
            }
        }
            
        return mincity;
            
        }
        
        void floyd_warshwall(int n , int[][] cities){
            for(int k=0;k<n;k++){
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        cities[i][j] = Math.min(cities[i][j] , cities[i][k] + cities[k][j]);
                    }
                }
            }
        }
}
