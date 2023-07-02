import java.util.ArrayList;

public class day77 {
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        while(head!=null){
            arr.add(head.val);
            head = head.next;
        }
        return helper(arr, 0, arr.size()-1);
    }

    TreeNode helper(ArrayList<Integer> arr, int start, int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = helper(arr, start, mid-1);
        root.right = helper(arr, mid+1, end);
        return root;
    }
}
