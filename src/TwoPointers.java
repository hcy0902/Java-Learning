import java.util.*;



public class TwoPointers {

    //LC 977, 189, (283, 26) , 167, 26,  344
    public static void main(String[] args) {


//        int [] nums = {-4,-1,0,3,10};
//        //System.out.println(Arrays.toString(sortedSquares(nums)));
//        System.out.println(Arrays.toString(sortedSquaresRewind(nums)));

//        int [] nums = {1,2,3,4,5,6,7};
//        //rotate(nums, 3);
//        rotateRewind(nums, 3);

//        String words = "Let's take LeetCode contest";
//        System.out.println(reverseWords(words));

        System.out.println(backSpaceCompareSkip("y#fo##f", "y#f#o##f"));

        //System.out.println(threeSum(new int[] {-1,0,1,2,-1,-4}));




        int[] numZero = {0,1,0,3,12};
        //reverseArray(numZero, 0, numZero.length-1);
        //System.out.println(Arrays.toString(numZero));
        //moveZeros(numZero);

        //moveZerosKeepOrder(numZero);

        //System.out.println(Arrays.toString(twoSums(new int[]{2,7,11,15}, 9)));

//        int[] nums = {0,1,1,2,3,3,4,4,5,6,7,7,9};
//        System.out.println(removeDuplicates(nums));

//        char[] s = {'h','e','l','l','o'};
//
//        reverString(s);
//        reverseStringSimple(s);


    }



    //LC 977  Using two pointer,  With a sorted int array, return sorted squares of int array
    public static int[] sortedSquares(int[] nums) {


        LinkedList<Integer> linky = new LinkedList<>();

        linky.add(78);
        linky.add(28);
        linky.add(9);

        Iterator it = linky.iterator();

        while(it.hasNext())
        {
            if ((int) it.next() == 78)
            {
                System.out.println(78);
            }
        }

        int left = 0;
        int right = nums.length-1;
        int result = nums.length-1;

        int[] results = new int[nums.length];

        while (right >= left)
        {
            int leftVal = Math.abs(nums[left]);
            int rightVal = Math.abs(nums[right]);

            if (rightVal > leftVal)
            {
                results[result] = nums[right]*nums[right];
                right--;
            }
            else
            {
                results[result] = nums[left]*nums[left];
                left++;
            }
            result--;
        }

        return results;
    }

    //LC 977 Rewind
    public static int[] sortedSquaresRewind (int[] nums)
    {

        int [] results = new int[nums.length];
        int left = 0;
        int right = nums.length-1;
        int result = results.length-1;
        while (right >= left)
        {
            int leftVal = nums[left]*nums[left];
            int rightVal = nums[right]* nums[right];
            if (leftVal > rightVal)
            {
                results[result] = leftVal;
                left++;
            }else
            {
                results[result] = rightVal;
                right--;

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

    // LC 189 Rewind
    public static void rotateRewind (int [] nums, int k )
    {
        // just in case k is greater than the length of nums
        k = k % nums.length;
        // in order to rotate k steps, need to reverse 3 times
        reverseRewind(nums,0, nums.length-1);
        reverseRewind(nums, 0, k-1);
        reverseRewind(nums, k, nums.length-1);

        System.out.println(Arrays.toString(nums));


    }

    public static void reverseRewind (int [] nums, int start, int end)
    {

        int temp = 0;
        while (end > start)
        {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            end--;
            start++;
        }


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




        //right keep moving, left is used to mark where the zeros are; nums[left] will always be 0 in this logic
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

    //LC 26 Remove duplicates
    //Return how many unique number in the array.
    private static int removeDuplicates(int[] nums)
    {
        int right = 1;
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


    // lc 344
    private static void reverString(char[] s)
    {
        int right = s.length-1;
        int left = 0;
        char temp = ' ';

        while (right > left)
        {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            right--;
            left++;
        }
        System.out.println(s);
    }

    // lc 344
    private static void reverseStringSimple (char[] s)
    {
        char temp = ' ';
        for (int i =0;  i< s.length/2; i++)
        {
            temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length-1-i] = temp;
        }

        System.out.println(s);

    }

    //lc 557 Reverse words in a String keep spaces and word order
    private static String reverseWords(String s)
    {
        StringBuilder result = new StringBuilder();

        String[] words = s.split(" ");

        for (String word : words)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(word);
            sb.reverse();

            result.append(sb);
            result.append(" ");
        }

        return result.toString().strip();
    }



    //LC 844
    public static boolean backspaceCompare(String s, String t) {


        StringBuilder newS = new StringBuilder();
        StringBuilder newT = new StringBuilder();

        char[] sChars  = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (char c:sChars){
            if (c == '#' ){
                if (newS.length()>=1){
                    newS.deleteCharAt(newS.length()-1);
                }
            }else{
                newS.append(c);
            }
        }

        for (char c:tChars){
            if (c == '#'){
                if (newT.length()>=1) {
                    newT.deleteCharAt(newT.length() - 1);
                }
            }else{
                newT.append(c);
            }
        }

        if (newS.toString().equals(newT.toString())){
            return true;
        }

        return false;

    }

    ////LC 844 using skip method

    public static boolean backSpaceCompareSkip(String s, String t){

        return build(s).equals(build(t));

    }

    private static String build(String s) {

        StringBuilder sb = new StringBuilder();
        int skip = 0;

        for (int i = s.length()-1; i>= 0; i--){
            char c = s.charAt(i);
            if (c == '#'){
                skip++;
            }else{
                if(skip >0){
                    skip--;
                }else{
                    sb.append(c);
                }
            }
        }
        return sb.toString();

    }


    //lc 15 3SUM

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList();


        List<Integer> seen = new ArrayList();

        for(int i = 0; i < nums.length-2; i++){
            if (!seen.contains(nums[i])){
                findTwoSum(results, nums, nums[i], i+1);
            }
            seen.add(nums[i]);
        }

        return results;


    }

    public static void findTwoSum(List<List<Integer>> results, int[] nums, int num, int index){


        int target = 0 - num;

        int left = index;
        int right = nums.length-1;

        while(right > left){
            if (nums[left] + nums[right] == target){
                results.add(Arrays.asList(nums[left], nums[right], num));
                while(left < right && nums[left] == nums[left+1]) left++;
                while(left < right && nums[right] == nums[right-1]) right--;
                left++;
                right--;
            }else if (nums[left]+ nums[right] > target){
                right--;
            }else{
                left++;
            }
        }
        return;


    }

    //LC 11 Container of water
    public int findMaxArea(int[] height){

        int max = 0;
        int left = 0;
        int right = height.length-1;

        // two pointer move from each end
        while(right >left){
            if (height[right] > height[left]){
                // area is determined by the shorter side, we wanna move the shorter side to middle
                max = Math.max(max, height[left]* (right-left));
                left++;
            }else{
                max = Math.max(max, height[right]* (right-left));
                right--;
            }
        }

        return max; 
    }

}
