import java.util.*;
public class day32 {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {       int n = status.length;
        boolean[] visited = new boolean[n];
        boolean[] found = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        for(int i : initialBoxes){
            found[i] = true;
            q.offer(i);
        }

        int candy = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            if(status[curr]==1 && !visited[curr]){
                candy+=candies[curr];
                visited[curr] = true;
                for(int key : keys[curr]){
                    status[key]=1;
                    if(found[key]){
                        q.offer(key);
                    }
                }
                for(int c : containedBoxes[curr]){
                    found[c] = true;
                    q.offer(c);
                }
            }
        }
        return candy;

    }
}
