public class day93 {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prev, temp;
        prev = slow;
        slow = slow.next;
        prev.next = null;
        while(slow!=null){
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        fast = head;
        slow = prev;
        while(slow!=null){
            if(fast.val!=slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
 
     }
}
