public class day95 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;
        ListNode x =head, y = head;
        int c = 0;
        while(temp!=null){
            c++;
            if(c==k){
                x = temp;
            }
            temp = temp.next;
        }
        temp = head;
        for(int i=1;i<=c;i++){
            if(i==(c+1-k)){
                y=temp;
                break;
            }
            temp = temp.next;
        }
        int t = x.val;
        x.val = y.val;
        y.val = t;
        return head;
    }
}
