public class day89 {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root==null ){
            return false;
        }
        if(head==null){
            return true;
        }
        if(head.val==root.val){
            if(validatePath(head, root)){
                return true;
            }
        }
        return isSubPath(head, root.left) || isSubPath(head, root.right);

    }

    boolean validatePath(ListNode head, TreeNode root){
        if(root==null){
            return head==null;
        }
        if(head==null){
            return true;
        }
        if(head.val!=root.val){
            return false;
        }
        return validatePath(head.next, root.left) || validatePath(head.next, root.right);
    }
}
