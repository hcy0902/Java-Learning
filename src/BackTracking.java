import java.sql.Array;
import java.util.ArrayList;
import java.util.List;


//LC 21, 206, 77, 46, 784
public class BackTracking {


    public static void main(String[] args) {

//            BackTracking backTracking = new BackTracking();
//            System.out.println(backTracking.combine(4,2));

            for(int i = 0; i < 10; i +=2)
            {
                System.out.println(i);
            }

    }


    //21 Merge two Sorted Lists
    public ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        ListNode merge = new ListNode();
        ListNode head = merge;

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

        head.next = list1==null?list2: list1;

        return merge.next;


    }

    //LC 206 Reverse LinkedList
    public ListNode reversList(ListNode head){

        ListNode prev = null;
        ListNode current = head;

        while(current!= null)
        {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;

    }

    //LC 77
    public List<List<Integer>> combine(int n, int k) {

        //create a return type of list
        List <List<Integer>> results = new ArrayList();



        //create back tracking method, what we have are:
        // the final result(which we will add qualified list to it every round)
        // a new List as subList that will take care of each combination
        // n, because we need to add until n
        // k, when it is combination of lengtth of k, we add
        // index, where it start, it start with 1;
        backTracking (results, new ArrayList<>(), n, k, 1);

        return results;

    }

    private void backTracking(List<List<Integer>> results, ArrayList<Integer> temp, int n, int k, int index) {

        //first, as all recursive method dfs, we need set up when it stop
        // so when there is k length of combination, we add it to the results, and return
        if (temp.size() == k)
        {
            //to avoid reference to same list, since temp is changing, we need to make a new copy of temp
            results.add(new ArrayList(temp));
        }

        //we loop through until n, we start from 1, as first layer, then we backtrack and move down
        for (int i = index; i<= n; i++)
        {
            temp.add(i);
            // now we move down to next layer, since we will add from the next number, we do i+1 as index
            backTracking(results, temp, n, k, i+1);
            //after we added the combination and came back to this layer, we remove the next number
            temp.remove(temp.size()-1);
        }

    }


    //LC 46 Permutations
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();

        dfs(results, nums, 0);

        return results;

    }

    private void dfs(List<List<Integer>> results, int[] nums, int index) {

        if (index >= nums.length)
        {
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++)
            {
                result.add(nums[i]);
            }
            results.add(new ArrayList(result));
            return;
        }

        for (int i = index; i < nums.length; i++)
        {
            swap(nums, i, index);
            dfs(results, nums, index +1);
            swap(nums, index, i);
        }

    }

    public void swap (int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] =  nums[j];
        nums[j] =  temp;
    }


    //LC 784 Letter Case Permutation

    public List<String> letterCasePermutation(String s) {

        List<String> result = new ArrayList<>();

        char[] chars = s.toCharArray();

        dfw(result, chars, 0);
        return result;
    }

    private void dfw(List<String> result, char[] chars, int index) {

        if (index >= chars.length)
        {
            result.add(new String(chars));
            return;
        }

        if (!Character.isLetter(chars[index]))
        {
            dfw(result, chars, index+1);
            return;
        }

        chars[index] =  Character.toLowerCase(chars[index]);
        dfw(result, chars, index+1);

        chars[index] = Character.toUpperCase(chars[index]);
        dfw(result, chars, index +1);

    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
