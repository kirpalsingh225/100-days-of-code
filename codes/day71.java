import java.util.ArrayList;

public class day71 {
    ArrayList<Integer> arr = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        helper(root);
        return makeTree(0, arr.size()-1);
    }

    void helper(TreeNode root){
        if(root==null){
            return;
        }
        helper(root.left);
        arr.add(root.val);
        helper(root.right);
    }

    TreeNode makeTree(int start, int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(arr.get(mid));
        node.left = makeTree(start, mid-1);
        node.right = makeTree(mid+1, end);
        return node;
        
    }
}
