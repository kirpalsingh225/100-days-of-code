import java.util.Stack;

public class day98 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = listToStack(l1);
        Stack<Integer> s2 = listToStack(l2);
        ListNode head = null;
        int carry = 0;
        while(!s1.isEmpty() || !s2.isEmpty() || carry!=0){
            int sum = carry;
            if(!s1.isEmpty()){
                sum+=s1.pop();
            }
            if(!s2.isEmpty()){
                sum+=s2.pop();
            }
            ListNode newnode = new ListNode(sum%10);
            newnode.next = head;
            head = newnode;
            carry = sum/10;
        }
        return head;
    }

    public Stack<Integer> listToStack(ListNode head){
        Stack<Integer> s = new Stack<>();
        while(head!=null){
            s.push(head.val);
            head = head.next;
        }
        return s;
    }
}
