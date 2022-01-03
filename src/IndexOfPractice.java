public class IndexOfPractice {
//find occurences of needle in haystack
    public static void main(String[] args) {

        String haystack = "This is a test sentence with test words for test";
        String needle = "test";
        int i = 0;
        System.out.println(strStr(haystack, needle));
        System.out.println(haystack.indexOf(needle));
        System.out.println(haystack.indexOf(needle, i));

    }

    private static int strStr(String haystack, String needle) {

        if (needle.isEmpty() || needle.isBlank())
        {
            return 0;
        }

        int counter = 0;
        int start= 0;
        while(true)
        {

            int found = haystack.indexOf(needle, start);
            if (found == -1)
            {
                break;
            }

            counter++;
            start = found + needle.length();

        }

        return counter;

    }
}
