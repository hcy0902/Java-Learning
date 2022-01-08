public class LinkyList {


    //lc 19, 876
    public static void main(String[] args) {



    }



    //LC 19 Remove nth node from the end of the linked List
    private static ListNode removeNode (ListNode head, int n)
    {

        //First we wanna find the length of the linkedList
        ListNode pointer = head;
        int length = 0;

        while (pointer != null && pointer.next != null)
        {
            pointer = pointer.next;
            length++;

        }

        //Now we have the length, we can calculate what is the position of the node that needs to be delete
        int position = length - (n-1);

        //Then we want to find the previous node from the one that needs to be deleted, store in temp
        ListNode temp = head;
        for (int i =0; i < position-1; i++)
        {
            temp = temp.next;
        }

        //Define the next node after the one that needs to be deleted
        ListNode next = temp.next.next;

        //make the node to be deleted to be the one after it (so it would be rid of )

        temp.next = next;

        // bear in mind the whole time temp.next is the one that need to be deleted.



        return head;
    }


    //LC 19 Two pointer method
    private static ListNode twoPointerRemove(ListNode head, int n)
    {

        // Two pointers both start from the head
        ListNode start = head;
        ListNode end = head;

        for (int i =0; i<n; i++)
        {
            start = start.next;

        }

        // check if start is null, if so, means the list is too short
        if (start == null)
        {
            return end.next;
        }

        // move both pointers, so that start would hit the end of the list, while
        // end would hit the position of the node before the target node
        while(start != null && start.next != null)
        {
            start = start.next;
            end = end.next;
        }

        // now end is the node before the target node
        // check the target node, if it is null, return null
        if (end.next == null)
        {
            return null;
        }

        // make a node next to be the node after the target node
        ListNode next = end.next.next;

        // make the target node to be next

        end.next = next;

        return head;


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
