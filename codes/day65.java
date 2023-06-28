public class day65 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res= new ArrayList<>();
        if(root == null) return res;
        HashMap<TreeNode, TreeNode> m = new HashMap<>();
        findParent(m, root);
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        q.add(target);
        
        while(!q.isEmpty()){
            int size= q.size();
            for(int i =0; i <size; i++){
                TreeNode curr = q.poll();
                visited.add(curr);
                if(K == 0){
                  res.add(curr.val);
                }
                if(m.containsKey(curr) && !visited.contains(m.get(curr))){
                    q.add(m.get(curr));
                }
                
                if(curr.left != null && !visited.contains(curr.left)){
                    q.add(curr.left);      
                }
                
                if(curr.right != null && !visited.contains(curr.right)){
                    q.add(curr.right);      
                }
            }
            K--;
            if(K < 0) break;
        }
        return res;
    }
    
    
    void findParent(HashMap<TreeNode, TreeNode> hm, TreeNode root){
        if(root == null) return;
        if(root.left != null)
            hm.put(root.left, root);
        
        if(root.right != null)
            hm.put(root.right, root);
    
        findParent(hm, root.left);
        findParent(hm, root.right);
        return;
    }
}
