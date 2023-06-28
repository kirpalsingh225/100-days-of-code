public class day66 {
    public int minimumOperations(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> lst = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode temp = q.poll();
                lst.add(temp.val);
                if(temp.left!=null){
                    q.offer(temp.left);
                }
                if(temp.right!=null){
                    q.offer(temp.right);
                }
            }
            ans+=helper(lst);
            
        }
        return ans;
    }
    int helper(List<Integer> lst){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<lst.size();i++){
            map.put(lst.get(i), i);
        }
        Collections.sort(lst);
        boolean[] b = new boolean[lst.size()];
        int var = 0;
        for(int i=0;i<lst.size();i++){
            if(b[i] || map.get(lst.get(i))==i){
                continue;
            }
            int j=i,m=0;
            while(!b[j]){
                b[j] = true;
                j=map.get(lst.get(j));
                m++;
            }
            if(m>0){
                var+=m-1;
            }
        }
        return var;
    }
}
