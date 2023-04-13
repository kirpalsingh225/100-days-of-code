public class day6 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] result = new int[2];

        for(int i=0;i<parent.length;i++){
            parent[i] = i;
        }

        for(int[] x : edges){
            int n1 = x[0];
            int n2 = x[1];

            int p1 = parent(n1, parent);
            int p2 = parent(n2, parent);

            if(p1==p2){
                result = x;
            }
            parent[p1] = p2;
        }
        return result;
    }
    int parent(int v, int[] parent){
        if(v==parent[v]){
            return v;
        }
        else{
            return parent(parent[v], parent);
        }
    }
}
