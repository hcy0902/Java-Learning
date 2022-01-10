public class Practice {

    public static void main(String[] args) {


        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));

    }

    //removeDuplicate Rewind

    public static int removeDuplicateRewind(int[] nums)
    {
        int left = 0;
        int right = 1;

        while (right < nums.length)
        {
            if (nums[left]!= nums[right])
            {
                nums[++left] = nums[right];
                right++;
            }
            else
            {
                right++;
            }
        }

        return ++left;


    }

    public static int removeDuplicates(int[] nums) {

        int right = 1;
        int sub = 0;
        int left = 0;

        while (right < nums.length)
        {
            if (nums[right] != nums[left])
            {
                left++;
                nums[left] = nums[right];
                right++;
            }
            else
            {
                right++;
            }

        }

        return ++left;
    }
}
