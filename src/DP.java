import java.util.ArrayList;
import java.util.List;

// LC 70, 198, 120
public class DP {

    public static void main(String[] args) {


        DP dp = new DP();


       dp.minimumTotal(new ArrayList<>() );
    }


    public int minimumTotal(List<List<Integer>> triangle) {

        int[] dp = new int[triangle.size()+1];

        dp[0] = 0;
        dp[1] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++)
        {
            dp[i+1] = dp[i] + Math.min(triangle.get(i).get(i-1), triangle.get(i).get(i));
        }

        return dp[triangle.size()];

    }

    //LC 70 Climbing stairs
    public static int climbStair(int n)
    {
        // at nth step, we have two ways to get here, one is take one step from n-1 or take two steps from n-2

        int[] dp = new int[n+1];
        //at zero step, we set to 1 for dp[2] because at 2nd step we have two ways to get there and dp[2] = dp[1] + dp[0]
        dp[0] = 1;
        //at first step, we only have one way to get to first step
        dp[1] = 1;

        for (int i = 2; i <=n; i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];

    }

    //LC 70 Rewind
    public static int climbStairRewind(int n)
    {
        //the idea is to find how many possible ways when we are at nth step
        // have an array DP record each step possible ways
        int[] dp = new int[n+1];
        // set dp[0] to 1 because we need to consider when we are at 2nd step, we have two ways
        dp[0] = 1;
        //dp[1]  is 1, because when we are at first step, we have one way
        dp[1] = 1;

        for (int i = 2; i <=n; i++)
        {
            // when at step i, we have two possible ways, take one step from i-1 or take two steps
            // from i-2. so we add these two possible ways together
            dp[i] = dp[i-1] + dp[i-2];
        }

        //n step ways
        return dp[n];

    }

    //LC 198 House Robber
    public static int rob (int[] nums)
    {
        int[] dp = new int[nums.length+1];

        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 1; i < nums.length; i++)
        {
            dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
        }

        return dp[nums.length-1];




    }

    //LC 198 Rewind

    public static int robRewind(int[] nums){

        int[] dp = new int[nums.length+1];

        dp[0] = 0;

        dp[1] = nums[0];

        for (int i = 1; i <= nums.length; i++)
        {
            dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
        }

        return dp[nums.length];

    }

    //LC 120 Triangle
    // dfs
    Integer[][] seen;
    public int minimumTotalRewind(List<List<Integer>> triangle)
    {
        //DFS 的主要一个点在于由上到下去找，从上一层到下一层，只有两种情况下去，那么我们就DFS 顺着这两个下去

        int result = 0;
        //define seen
        seen= new Integer[triangle.size()][triangle.size()];
        // start from the top, [0,0]
        result = dfs(triangle, 0, 0);




        return result;

    }

    private int dfs(List<List<Integer>> triangle, int i, int j) {

        if (i < 0 || j < 0 || i>= triangle.size() || j>= triangle.size())
        {
            return 0;
        }

        // if this has not been checked, we do the dfs call
        if (seen[i][j] == null)
        {
            // return the min of two path + the current node's value at i, j
            seen[i][j] = Math.min(dfs(triangle, i+1, j), dfs(triangle, i+1, j+1)) + triangle.get(i).get(j);
        }

        // if already checked, we skip dfs, just return its value
        return seen[i][j];

        //Above is good, but we need to keep in mind of time limitation, we can optimize this by skipping the repetitive
        //check, for example, 5 is checked twice by 3 and 4, we can mark 5 as seen so it only got checked once
        //   2
        //  3 4
        // 6 5 7
        //4 1 8 3

    }

    //LC 12
    //DP
    public int minimumTotalDp(List<List<Integer>> triangle)
    {
        // the main idea of using DP is to start from bottom to up, we need a 1d dp array to first store the
        //last row of the triangle, and work our way up, from bottom there is only two possible way going up
        // and that is what we are using
        int[] dp = new int[triangle.size()];

        //loop through the last row and put all into dp as initial values
        for (int i = 0; i < triangle.size(); i++)
        {
            dp[i] = triangle.get(triangle.size()-1).get(i);
        }

        // work out way up from the second to the last row
        for (int i = triangle.size()-2; i>= 0; i--)
        {
            // This loop is for the each element on each row
            for(int j = 0; j<=i; j++)
            {
                // this target can only have two path from bottom, j and j+1, we take the lesser value and add the current
                //target value
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];

    }

}
