import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoPointers {

    //LC 977, 189, 283
    public static void main(String[] args) {


        //int [] nums = {-4,-1,0,3,10};
        //System.out.println(Arrays.toString(sortedSquares(nums)));

        int [] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);

        int[] numZero = {0,1,0,3,12};
        //reverseArray(numZero, 0, numZero.length-1);
        //System.out.println(Arrays.toString(numZero));
        //moveZeros(numZero);

        //moveZerosKeepOrder(numZero);

        System.out.println(Arrays.toString(twoSums(new int[]{2,7,11,15}, 9)));


    }


    //LC 977  Using two pointer,  With a sorted int array, return sorted squares of int array
    public static int[] sortedSquares(int[] nums) {

        int left = 0;
        int right = nums.length-1;
        int result = nums.length-1;

        int[] results = new int[nums.length];

        while (right > left)
        {
            int leftVal = Math.abs(nums[left]);
            int rightVal = Math.abs(nums[right]);

            if (rightVal > leftVal)
            {
                results[result] = nums[right]*nums[right];
                right--;
            }
            else if (leftVal > rightVal)
            {
                results[result] = nums[left]*nums[left];
                left++;
            }
            result--;
        }

        return results;
    }

    //LC 189  rotate an array to right with k steps, k>0

    public static void rotate(int[] nums, int k) {


        //do this just in case k is greater than the lengh of nums
        k = k % nums.length;
        System.out.println(k);

        int len = nums.length;

        //first reverse the whole thing
        reverse(nums, 0, len-1);
        //then reverse the first K numbers
        reverse(nums, 0, k-1);
        //lastly, reverse the left over numbers
        reverse(nums, k, len-1);

        System.out.println(Arrays.toString(nums));
    }

    private static void reverse(int[] nums, int start, int end) {

        int right = end;
        int left = start;

        while (right > left)
        {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right]= temp;
            right--;
            left++;
        }

    }

    //LC 283

    private static void moveZeros(int[] nums)
    {

        // if no zero, return nums directly
        int ifnoZero = 0;

        for (int j = 0; j< nums.length; j++)
        {
            if (nums[j] == 0)
            {
                ifnoZero++;
            }
        }

        if (ifnoZero != 0)
        {
            int right = nums.length-1;
            int left = 0;

            Arrays.sort(nums);
            //0 0 1 3 12
            System.out.println("after sort: " + nums);

            reverseArray(nums, 0, (nums.length-1));
            System.out.println("after first reverse: " + nums);
            //12 3 1 0 0

            int index = 0;
            for (int i = 0; i < nums.length; i++)
            {
                if (nums[i] == 0)
                {
                    break;
                }
                index++;
            }

            reverseArray(nums, 0, index-1 );
            //1 3 12 0 0

            System.out.println(Arrays.toString(nums));
        }


    }


    //LC 283
    private static void moveZerosKeepOrder (int[] nums)
    {
        int right = 0;
        int left = 0;
        int temp = 0;




        //right keep moving, left is used to mark where the zeros are;
        while (right < nums.length)
        {

            if (nums[right] == 0 )
            {
                right ++;

            }
            else
            {
                temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
                right++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    private static void reverseArray(int[] nums, int start, int end) {

        int temp = 0;
        while (end > start)
        {
            temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }

    }


    //LC 167
    private static int[] twoSums(int[] numbers, int target)
    {
        Map<Integer, Integer> store = new HashMap<>();

        int[] result = new int[2];


        for (int i = 0; i < numbers.length; i++)
        {
            if (store.containsKey(target-numbers[i]))
            {
                result[0] = store.get(target-numbers[i])+1;
                result[1] = i+1;
                break;
            }
            else
            {
                store.put(numbers[i], i);
            }
        }

        return result;



    }

    //LC 167 TWO POINTER solution
    private static int[] twoSumsTwoPointer(int[] numbers, int target)
    {
        int left = 0;
        int right = numbers.length-1;


        // if sum too big, move right for a smaller number, if sum too small, move left for a bigger number
        while( right> left)
        {
            if (target == (numbers[right] + numbers[left]))
            {

                return new int[]{++left, ++right};
            }
            else if ((numbers[right] + numbers[left]) > target)
            {
                right--;
            }else
            {

                left++;
            }
        }

        return new int[]{0, 0};

    }
}
