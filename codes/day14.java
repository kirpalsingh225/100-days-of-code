public class day14 {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for(int i=0;i<26;i++){
            parent[i] = i;
        }

        for(String s : equations){
            if (s.charAt(1)=='='){
                union(s.charAt(0)-'a', s.charAt(3)-'a', parent);
            }
        }
        for(String s : equations){
            if (s.charAt(1)=='!'){
                int lx = find(s.charAt(0)-'a', parent);
                int ly = find(s.charAt(3)-'a', parent);
                if(lx==ly){
                    return false;
                }
            }
        }
        return true;
    }

    int find(int x, int[] parent){
        if(parent[x]==x){
            return x;
        }
        return find(parent[x], parent);
    }

    void union(int x, int y, int[] parent){
        int lx = find(x, parent);
        int ly = find(y, parent);

        if(lx==ly) return;
        parent[ly] = lx;
    }
}
