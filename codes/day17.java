import java.util.*;
public class day17 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, ArrayList<ArrayList<Integer>>> graph = new HashMap<>();
        for(int i=0;i<n;i++){
            graph.put(i, new ArrayList());
        }
        for(int i=0;i<blueEdges.length;i++){
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(blueEdges[i][1]);
            arr.add(1);
            graph.get(blueEdges[i][0]).add(arr);
        }
        for(int i=0;i<redEdges.length;i++){
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(redEdges[i][1]);
            arr.add(0);
            graph.get(redEdges[i][0]).add(arr);
        }
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        answer[0] = 0;
        boolean[][] v = new boolean[n][2];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, -1});
        while(!q.isEmpty()){
            int[] temp = q.poll();
            for(ArrayList<Integer> it : graph.get(temp[0])){
                if(!v[it.get(0)][it.get(1)] && it.get(1)!=temp[2]){
                    if(answer[it.get(0)]==-1){
                        answer[it.get(0)] = temp[1] + 1;
                    }
                    v[it.get(0)][it.get(1)]=true;
                    q.add(new int[]{it.get(0), temp[1]+1, it.get(1)});
                }
            }
        }
        return answer;
    }
}
