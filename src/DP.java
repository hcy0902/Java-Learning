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
    public int minimumTotalRewind(List<List<Integer>> triangle)
    {
        return 0;
    }

}
