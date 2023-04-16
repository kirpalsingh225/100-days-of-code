import java.util.*;
public class day16 {
    class node{
        int target;
        double prob;
        public node(int target, double prob){
            this.target = target;
            this.prob = prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<node>> graph = new HashMap<>();
        for(int i=0;i<n;i++){
            graph.put(i, new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int src = edges[i][0];
            int tar = edges[i][1];
            double prob = succProb[i];
            graph.get(src).add(new node(tar, prob));
            graph.get(tar).add(new node(src, prob));
        }

        double[] probability = new double[n];
        Arrays.fill(probability, 0);
        Queue<node> q = new LinkedList<>();
        q.offer(new node(start, 1));
        probability[start] = 1;

        while(!q.isEmpty()){
            node temp = q.poll();
            for(node x : graph.get(temp.target)){
                int v = x.target;
                double prob = x.prob;
                if(probability[temp.target]*prob>probability[v]){
                    q.offer(x);
                    probability[v] = probability[temp.target]*prob;
                }
            }
        }
        return probability[end];
    }
}
