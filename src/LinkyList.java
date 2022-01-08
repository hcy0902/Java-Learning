public class LinkyList {

    public static void main(String[] args) {



    }

    //LC 876 Middle node of a linked List
    private static ListNode middleNode(ListNode head)
    {
        // two pointers, slow and fast pointer. Both starts from head
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null)
        {
            // fast moves twice as fast as slow.
            // so when fast hits end, slow would hit the middle
            slow = slow.next;
            fast = fast.next.next;
        }

        // return the middle
        return slow;

    }

    public class ListNode {
     int val;
      ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
}
