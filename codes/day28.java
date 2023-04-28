import java.util.*;
public class day28 {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int n = vals.length;
        int[] arr = new int[n];
        

        for(int i=0;i<vals.length;i++){
            arr[i] = vals[i];
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int start = edges[i][0];
            int end = edges[i][1];
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        if(edges.length==0){
            Arrays.sort(vals);
            return vals[vals.length-1];
        }

        if(k==0){
            Arrays.sort(vals);
            return vals[vals.length-1];
        }

        int max_sum = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            ArrayList<Integer> adj = graph.get(i);
            ArrayList<Integer> temp = new ArrayList<>();
            for(int itr : adj){
                temp.add(arr[itr]);
            }
            Collections.sort(temp, Collections.reverseOrder());
            int ans = vals[i];
            int count = k;
            max_sum = Math.max(max_sum, ans);
            for(int v : temp){
                ans+=v;
                max_sum = Math.max(max_sum, ans);
                count--;
                if(count==0){
                    break;                
                }
            }
            
        }
        return max_sum;

    }
}
