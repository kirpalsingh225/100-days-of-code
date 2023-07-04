import java.util.ArrayList;
import java.util.List;

public class day96 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        List<Integer> lst = new ArrayList<>();
        ListNode temp = head;
        int cnt = 0;
        while(temp!=null){
            if(cnt%2==0){
                lst.add(temp.val);
            }
            cnt++;
            temp=temp.next;
        }
        temp = head;
        cnt = 0;
        while(temp!=null){
            if(cnt%2!=0){
                lst.add(temp.val);
            }
            cnt++;
            temp=temp.next;
        }
        ListNode newhead = null;
        ListNode tail = null;
        for(int i=0;i<lst.size();i++){
            ListNode newnode = new ListNode(lst.get(i));
            if(newhead==null){
                newhead = newnode;
                tail = newhead;
            }
            tail.next = newnode;
            tail=tail.next;
        }
        return newhead;
    }
}
