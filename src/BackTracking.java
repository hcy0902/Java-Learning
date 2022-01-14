import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class BackTracking {


    public static void main(String[] args) {

            BackTracking backTracking = new BackTracking();
            System.out.println(backTracking.combine(4,2));

    }



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


}