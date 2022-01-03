import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSums {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(twoSum(new int[]{2,6,5,3,7}, 9)));
    }

    private static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> storedNums = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
        {
            if (storedNums.containsKey(target-nums[i]))
            {
                return new int[]{i, storedNums.get(target-nums[i])};
            }else
            {
                storedNums.put(nums[i], i);
            }
        }
        return new int[]{};


    }
}
