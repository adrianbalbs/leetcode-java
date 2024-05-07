package doubleanumberrepresentedasalinkedlist;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode doubleIt(ListNode head) {
        int carry = doubleNode(head);
        return carry != 0 ? new ListNode(carry, head) : head;
    }

    int doubleNode(ListNode head) {
        if (head == null) return 0;
        int carry = doubleNode(head.next);
        int sum = head.val * 2 + carry;
        head.val = sum % 10;
        return sum / 10;
    }
}
