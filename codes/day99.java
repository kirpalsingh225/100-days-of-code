public class day99 {
    public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
        return true;
    }

    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    ListNode secondHalf = reverseList(slow); 
    while (secondHalf != null) {
        if (head.val != secondHalf.val) {
            return false;
        }
        head = head.next;
        secondHalf = secondHalf.next;
    }

    return true;
}

private ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    return prev;
}
}
