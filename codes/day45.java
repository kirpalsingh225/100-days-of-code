public class day45 {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        int maxfreq = -1;
        List<Integer> lst = new ArrayList<>();

        for(int k : map.keySet()){
            int freq = map.get(k);
            if(maxfreq<freq){
                maxfreq=freq;
                lst.clear();
                lst.add(k);
                continue;
            }
            if(maxfreq==freq){
                lst.add(k);
            }
        }
        int[] ans = new int[lst.size()];
        for(int i=0;i<lst.size();i++){
            ans[i] = lst.get(i);
        }
        return ans;
        
    }

    void dfs(TreeNode root, Map<Integer, Integer> map){
        if(root==null){
            return;
        }
        if(map.containsKey(root.val)){
            map.put(root.val, map.get(root.val)+1);
        }
        else{
            map.put(root.val, 1);
        }
        dfs(root.left, map);
        dfs(root.right, map);
    }
}
