import java.util.HashMap;
import java.util.Map;

public class Practice {

    public static void main(String[] args) {


//        int[] nums = {0,0,1,1,1,2,2,3,3,4};
//        System.out.println(removeDuplicates(nums));
        //System.out.println(reverseInt(1234));
        //System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));

        findMin(new int[]{3,1,2});

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

    public static int reverseInt (int n)
    {
        int answer = 0;
        while (n > 0)
        {
            answer = answer *10 + n % 10;
            n/= 10;
        }


        return answer;
    }

    public static int singleNumber(int[] nums) {

        if (nums.length == 1)
        {
            return nums[0];
        }

        Map<Integer, Integer> numbers = new HashMap();

        for(int i = 0; i < nums.length; i ++)
        {
            if (!numbers.containsKey(nums[i]))
            {
                numbers.put(nums[i], 1 );

            }else
            {
                numbers.put(nums[i], 2);
            }
        }
        int answer = 0;

        for (Map.Entry<Integer, Integer> entry : numbers.entrySet())
        {
            if (entry.getValue() == 1)
            {
                answer = entry.getKey();
            }
        }



        return answer;

    }


    public static int findMin(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }


        int left= 0;
        int right = nums.length-1;

        while(right > left){

            int mid = left + (right-left)/2;
            if (nums[mid] > nums[right]){
                left = mid+1;
            }else{
                right = mid;
            }
        }


        return nums[left];

    }
}
