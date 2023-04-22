import java.util.*;
public class day22 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<edges.size();i++){
            int end = edges.get(i).get(1);
            indegree[end]++;
        }
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                ans.add(i);
            }
        }

        return ans;
    }
}
