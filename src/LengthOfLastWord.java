import java.util.Arrays;

public class LengthOfLastWord {

    public static void main(String[] args) {

        String test = "This is    a  test  String";

        Arrays.stream(test.split("\\s+")).forEach(s -> System.out.println(s));
        System.out.println(Arrays.toString(getWords(test)));
        System.out.println(lengthOfLast(test));

    }

    private static String[] getWords(String test) {

        String [] words = test.split("\\s+");
        return words;
    }

    private static int lengthOfLast(String s) {

        int ans=0;
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)!=' ')
                ans++;
            if(ans!=0 && s.charAt(i)==' ')
                break;
        }
        return ans;
    }

}
