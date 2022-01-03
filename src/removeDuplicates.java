import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class removeDuplicates {

    public static void main(String[] args) {


//        String testString = "This is a test string, type anything; in here with. any special, characters";
//        String test2 = "Test; String; Split; With: Comma";
//        String[] words = testString.split("[ ,;.]");
//        Arrays.asList(test2.split("[ ;:]")).stream().forEach(s -> System.out.print(s + " "));
//        //System.out.println(words);
//        Arrays.asList(words).stream().forEach(s -> System.out.print(s) );
//        System.out.println();
//
//        getWords(testString);
//
        int[] nums = {1,2,2,2,3,3,4,5,7,7,9,10,11,13,13,16,19,20};
        System.out.println(Arrays.toString(findDuplicate(nums)));
//        System.out.println();
//
        String test = "   I  Love    Java \n";
        String moreTest = "This is a test";
        System.out.print(test.replaceAll("\\s", ""));
//        System.out.println(moreTest);

//        System.out.println(inputDate);
//        System.out.println(formatIssueDateFromRemarks);

        String dateNeedFormat = "10Nov22";
        String expirationDate = null;
        String actualDate = formatDate(dateNeedFormat);
        String expectedDate = "2022-11-10";
        System.out.println(formatDate("2022-11-10"));
        System.out.println(actualDate);
        System.out.println(expectedDate);
        System.out.println(formatDate(expirationDate));
//        String test = "I love java";
//
//        System.out.println(test.substring(0,1));
//        System.out.println(test.substring(1));


    }

    private static void getWords(String sentence) {
        Arrays.asList(sentence.split("[ ,;.!?]")).stream().forEach(s -> System.out.print(s));

    }

    private static int[] findDuplicate(int[] nums) {

        int i = 0;
        for (int j = 1; j < nums.length; j++)
        {
            if (!(nums[i] == nums[j]))
            {
                i++;
                nums[i] = nums[j];
            }

        }
        return nums;


    }

    public static String formatDate(String expirationDate) {


            try {
                Date dateNeedFormat = new SimpleDateFormat("ddMMMyy").parse(expirationDate);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                return formatter.format(dateNeedFormat);
            } catch (Exception exception) {
                exception.printStackTrace();
                return null;
            }



    }


}
