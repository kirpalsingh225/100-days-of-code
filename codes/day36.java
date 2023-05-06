import java.util.*;
public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
public class day36 {
    int sum=0;
    List<Integer> list = new ArrayList<>();
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }

        helper(root);
        check(low, high);
        return sum;
    }
    void helper(TreeNode root){
        if(root==null){
            return;
        }
        else{
            helper(root.left);
            list.add(root.val);
            helper(root.right);
        }
    }

    void check(int low, int high){
        for(int i=0;i<list.size();i++){
            if(list.get(i)>=low && list.get(i)<=high){
                sum = sum + list.get(i);
            }
        }
    }
}
}
