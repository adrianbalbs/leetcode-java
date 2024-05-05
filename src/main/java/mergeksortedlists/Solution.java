package mergeksortedlists;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
     public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;
        ListNode top = merge(lists, start, mid);
        ListNode bot = merge(lists, mid + 1, end);

        ListNode mergedList = new ListNode();
        ListNode head = mergedList;
        while (top != null && bot != null) {
            if (top.val < bot.val) {
                head.next = new ListNode(top.val);
                top = top.next;
            } else {
                head.next = new ListNode(bot.val);
                bot = bot.next;
            }
            head = head.next;
        }

        if (top == null) {
            head.next = bot;
        } else {
            head.next = top;
        }

        return mergedList.next;
    }

}
