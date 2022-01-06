public class BinarySearch {
    public static void main(String[] args) {

        int[] nums = {1,3,5,6};
        int target = 7;
        //System.out.println(search(nums, target));

       System.out.println(firstBadVersion(3));

       // System.out.println(searchInsert(nums, target));


    }

    //LC 704
    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;



        while (right >= left)
        {
            int mid = left + (right - left)/2;

            if (target == nums[mid])
            {
                return mid;
            }
            else if (target > nums[mid])
            {
                left = mid+1;
            }else
            {
                right = mid-1;
            }


        }


        return -1;
    }

    //LC 278
    public static int firstBadVersion(int n) {

        int left = 1;
        int right = n;
        int mid = 0;
        while (right >= left)
        {
            mid = left + (right-left)/2;

            if (isBadVersion(mid) == true)
            {
                if (isBadVersion(mid-1) == true)
                {
                    right = mid-1;
                }else
                {
                    return mid;
                }
            }else if (isBadVersion(mid) == false)
            {
                left = mid +1;
            }


        }
        return mid;
    }

    private static boolean isBadVersion(int mid) {

        if (mid >= 1)
        {
            return true;
        }
        return false;
    }


    /* LC 35
    * Given a sorted array of distinct integers and a target value, return the index if the target is found.
    * If not, return the index where it would be if it were inserted in order.*/
    public static int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;
        int mid = 0;

        //initialize to 0 to consider if target is smaller than any number in array
        int answer = 0;

        // take into consideration if target is greater than any number in array
        if (target>= nums[nums.length-1])
        {
            answer = nums.length;
        }

        while (right >= left)
        {
            mid = left + (right-left)/2;
            if (nums[mid] == target)
            {
                return mid;
            }
            else if (nums[mid] > target)
            {
                answer = mid;
                right = mid -1;
            }
            else
            {
                left = mid +1;
            }

        }
        return answer;

    }
}
