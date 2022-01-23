import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class BinarySearch {

    //LC 704 278, 35, 34, 74, 33, 153, 162
    public static void main(String[] args) {

        int[] nums = {1,3,5,6};
        int target = 7;
        //System.out.println(search(nums, target));

       //System.out.println(firstBadVersion(3));

        //System.out.println(searchRange(new int[]{5,7,7,8,8,10}, 8));

       // System.out.println(searchInsert(nums, target));
        int[][] matrix = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(matrix, 3));

        Queue<Character> queue = new Queue<>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Character> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Character character) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Character> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public boolean offer(Character character) {
                return false;
            }

            @Override
            public Character remove() {
                return null;
            }

            @Override
            public Character poll() {
                return null;
            }

            @Override
            public Character element() {
                return null;
            }

            @Override
            public Character peek() {
                return null;
            }
        };



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

    //lc 34
    public static int[] searchRange(int[] nums, int target) {

        if (nums.length == 0)
        {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = nums.length-1;

        int[] answer = new int[2];

        int count = 0;


        while (right < nums.length && left>=0)
        {
            if (nums[right] == target)
            {
                answer[1] = right;
                count++;
            }
            if (nums[left] == target)
            {
                answer[0] = left;
                count++;
            }
            if (count ==2)
            {
                break;
            }
            right--;
            left++;
        }

        if (count == 0)
        {
            return new int[]{-1, -1};
        }

        return answer;


    }

    //LC 74
    public static boolean searchMatrix(int[][] matrix, int target) {

        int i = 0;
        int j = matrix[0].length;

        while(i < matrix.length && j>=0){
            if (matrix[i][j] == target){
                return true;
            }else if (matrix[i][j] > target){   //means this row is sufficient, search in this row
                j--;
            }else{  //means even the largest of this row is too small, we need to go next row
                i++;
            }
        }


        return false;
    }

    //LC 34 REWIND
    public int[] findFirstAndLastElementInSortedAray(int[] nums, int target){

        int[] result = new int[2];

        result[0] = leftMostIndex(nums, target);
        result[1] = rightMostIndex(nums, target);

        return result;

    }

    private int leftMostIndex(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;
        int index = -1;

        while(right >= left){
            int mid = left+(right-left)/2;
            if (nums[mid] >= target){
                right = mid -1;

            }else{
                left = mid +1;
            }

            if(nums[mid] == target){
                index = mid;
            }
        }

        return index;

    }

    private int rightMostIndex(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;
        int index = -1;

        while(right >= left){
            int mid = left+(right-left)/2;
            if (nums[mid] <= target){
                left = mid +1;

            }else{
                right = mid -1;
            }

            if(nums[mid] == target){
                index = mid;
            }
        }

        return index;
    }

    //LC 153 Find Minimum in rotated array
    public int findMinimum(int[] nums){

        // if array only has one element, the only one would be the minimum
        if (nums.length == 1){
            return nums[0];
        }

        int left =0;
        int right = nums.length -1;

        while (right > left){
            int mid = left+(right-left)/2;
            if (nums[mid] > nums[right])    // if mid is greater than right, means it is weird
            {
                left = mid +1;
            }else{
                right = mid;
            }
        }

        return nums[left];

    }


    //LC 162 Find peak element

    public int findPeakElement(int[] nums){


        // if only one element in array, return the only index which is 0
        if (nums.length == 1){
            return 0;
        }

        int left = 0;
        int right = nums.length-1;

        // right -1 for out of bound concerns, since we need to compare mid +1
        while (right-1 > left){
            int mid = left + (right-left)/2;

            if (nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]){
                return mid;
            }
            else if (nums[mid] > nums[mid+1]){   //if mid is greater than its right neighbor, we know left has greater values
                right = mid -1;
            }else{
                left = mid +1;
            }

        }

        // if the while loop ends and no return yet, we get here, and we wanna compare left and right value
        if (nums[left] > nums[right]){
            return left;
        }else{
            return right;
        }



    }

    public int findPeakElementMyWay(int[] nums){

        //if there are one element, we return 0
        if (nums.length == 1){
            return 0;
        }

        //we need to handle edge cases
        if(nums.length >= 2 && nums[0] > nums[1]){
            return 0;
        }
        if (nums.length >= 2 && nums[nums.length-1] > nums[nums.length-2]){
            return nums.length-1;
        }

        for (int i = 1; i < nums.length-1; i++){
            if (nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                return i;
            }
        }

        return 0;
    }
}
