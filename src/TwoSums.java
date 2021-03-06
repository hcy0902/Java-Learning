import java.util.*;

public class TwoSums {

    public static void main(String[] args) {

        //System.out.println(Arrays.toString(twoSum(new int[]{2,6,5,3,7}, 9)));

        int[] nums = {1,2,6,9,3,5};
        int target = 12;
        List<Integer> store = new ArrayList<>();

        for (int i = 0; i < nums.length; i++)
        {
            if (store.contains(target-nums[i]))
            {
                System.out.println(nums[i] + " and" + (target-nums[i]));
            }
            else
            {
                store.add(nums[i]);
            }

        }


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
