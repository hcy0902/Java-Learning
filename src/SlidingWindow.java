import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SlidingWindow {

    //LC 3
    public static void main(String[] args) {

        //LC3
        System.out.println(lengthOfLongest("abcabcbb"));

        //LC567
        System.out.println(checkInclusion("adc", "dcda"));

        String test = "test";


    }


    //LC3 Find the longest substring with non repeating characters.
    private static int lengthOfLongest(String s)
    {
        //we will have two pointers start from beginning, right keeps moving and left stay
        int left = 0;
        int right = 0;
        HashSet<Character> chars = new HashSet<>();
        int max = 0;

        while (right< s.length())
        {
            // if not contain the char, add it to hashset, and update max
            if (!chars.contains(s.charAt(right)))
            {
                chars.add(s.charAt(right));
                right++;
                max = Math.max(chars.size(), max);
            }
            // if contains the char, remove the one from the beginning, because it cannot start from there anymore
            else
            {
                chars.remove(s.charAt(left));
                left++;
            }

        }

        return max;

    }


    //LC3 rewind
    private static int lengthOfLongestRewind(String s)
    {
        //we need two pointers both start from beginning

        int left = 0;
        int right = 0;
        int max = 0;

        //Need a hashset to record the chars
        HashSet<Character> chars = new HashSet<>();

        //right keep going
        while(right < s.length())
        {
            if (!chars.contains(s.charAt(right)))
            {
                chars.add(s.charAt(right));
                right++;
                //update max too
                max = Math.max(chars.size(), max);
            }else
            {
                chars.remove(s.charAt(left));
                left++;
            }


        }

        return max;



    }

    //LC 567
    private static boolean checkInclusion(String s1, String s2)
    {

        // First have two pointers left and right definning how long s1 is
        int left = 0;
        int right = s1.length();

        // if s1 is longer than s2, return false
        if (s1.length() > s2.length())
        {
            return false;
        }

        //sort s1
        String sorted = sortString(s1);

        while(right< s2.length())
        {
            String sortS2 = sortString(s2.substring(left, right));
            if (sorted.equals(sortS2))
            {
                return true;
            }
            else
            {
                left++;
                right++;
            }
        }

        return false;

    }

    //LC 567 rewind
    private static boolean checkInclusionRewind(String s1, String s2)
    {
        //Two pointers to define the length of the window to be s1's length
        int left = 0;
        int right = s1.length();

        //sort s1
        String sortedS1 = sortString(s1);

        //loop trough s2 to find each, use <= because substring exclude the right edge
        while(right <= s2.length())
        {
            String sortedS2 = sortString(s2);
            if (sortedS2.equals(sortedS1))
            {
                return true;

            }
            else
            {
                left++;
                right++;
            }

        }

        return false;


    }

    private static String sortString(String s1) {

        char[] c = s1.toCharArray();
        Arrays.sort(c);

        return new String(c);
    }
}
