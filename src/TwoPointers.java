import java.util.Arrays;

public class TwoPointers {

    //LC 977, 189
    public static void main(String[] args) {


        //int [] nums = {-4,-1,0,3,10};
        //System.out.println(Arrays.toString(sortedSquares(nums)));

        int [] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);
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

}
