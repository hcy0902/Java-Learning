import java.util.ArrayList;
import java.util.List;

public class LinkyList {


    //lc 19, 876, 206, 82, 83
    public static void main(String[] args) {
        int number = 8;
        System.out.println( number % 2 == 0 );

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

    //LC 206 Reverse a Linked List
    private static ListNode reverseLinkedList (ListNode head)
    {
        //Two pointers, one is prev, one is current
        // initialize Prev to be null, current to be head
        ListNode prev = null;
        ListNode current = head;

        while(current != null)
        {
            //we want to change the next node after current to be the prev. first we store the next node
            ListNode next = current.next;

            //change next node to be prev
            current.next = prev;
            //move prev to be current
            prev = current;
            // move current to be next
            current = next;

        }

        return prev;

    }

    public static class ListNode {
     int val;
      ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    //LC 234 Palindrome LinkedList
    private boolean palindrome (ListNode head)
    {

        //create  a list to store all values from nodes
        List<Integer> values = new ArrayList<>();
        while (head != null)
        {
            values.add(head.val);
            head = head.next;
        }

        //now list has all values, we wanna loop trough it check from back to start
        for (int i =0; i< values.size(); i++)
        {
            if (values.get(i) != values.get(values.size() -i -1))
            {
                return false;
            }

        }

        return true;

    }

    //LC 21 Merge two linkedList

    private static ListNode mergeTwo(ListNode list1, ListNode list2)
    {
        //declare a new LinkedList here, make the head
        ListNode merge = new ListNode();
        ListNode head = merge;
        //Since two list can be different length, first, we add how ever much we can

        while(list1 != null && list2 != null)
        {
            if (list1.val < list2.val)
            {
                head.next = list1;
                list1 = list1.next;
                head = head.next;

            }
            else
            {
                head.next = list2;
                list2 = list2.next;
                head = head.next;
            }

        }

        // after add all elements of the short list, we determine which one is longer, and add the rest
        head.next = list1 ==null?list2:list1;

        //and we return the merge.next since it started with head.next
        return merge.next;
    }

    //21 Merge two LinkedList rewind
    private static ListNode mergeTwoRewind (ListNode list1, ListNode list2)
    {
        ListNode merge = new ListNode();
        ListNode head = merge;

        while(list1 != null && list2 != null)
        {
            if(list1.val < list2.val)
            {
                head.next = list1;
                list1 = list1.next;
                head = head.next;
            }
            else
            {
                head.next = list2;
                list2 = list2.next;
                head = head.next;
            }
        }

        // now determine which list has anything left to be added
        head.next = list1==null?list2:list1;

        return merge.next;

    }

    // 82 Remove duplicates from a linked list

    public ListNode deleteDuplicates(ListNode head) {

        //Remember to use a prev and a dummy node to store new list
        // initial dummy node to be value of 0, and next to be head;
        ListNode dummy = new ListNode(0, head);
        // prev is used to mark the last seen unique node, we won't update this until we find a new unique
        ListNode prev = dummy;

        while(head!= null){
            if (head.next != null && head.val == head.next.val){
                while(head.next != null && head.val == head.next.val){
                    //if we find a duplicate, we keep going until we find no more duplicates and break out
                    head = head.next;
                }
                // update prev.next to the next (which is unique)
                prev.next = head.next;
            }else{
                //if we don't find a duplicate, update prev
                prev = prev.next;
            }
            // keep going no matter what
            head = head.next;
        }

        return dummy.next;


    }

    // LC 83 this is different from 82, if there are duplicates, we keep one

    public ListNode deleteDuplicates2(ListNode head) {

        ListNode current = head;


        while(current != null){
            if (current.next != null && current.val == current.next.val){
                // if we find a duplicate, we skip the next, update to the next after the next
                current.next = current.next.next;
            }else{
                // we won't update the current until we find a different node
                current = current.next;
            }
        }

        return head;

    }

}
