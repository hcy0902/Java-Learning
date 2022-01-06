public class LongestCommonPrefix {
//find the longest Prefix among words
    public static void main(String[] args) {
        String string1 = "Flower";
        String string2 = "Flow";
        String string3 = "Flowers";
        String string4 = "Flo";
        String string5 = "sajhdk";
        String combined = "FlowFloFlowerFloFlow";
//        System.out.println(string1.indexOf(string2));
//        System.out.println(string1.indexOf(string3));
//        System.out.println(string1.indexOf(string4));
//        System.out.println(string1.indexOf(string5));
        System.out.println(combined.indexOf(string4));
        System.out.println(longPrefix(new String[] {"flower", "flow","flight"}));



        System.out.println(longestPrefix(new String[]{"flower","flow","flight"}));
    }



    private static String longPrefix(String [] words)
    {
        String prefix = words[0];

        for (int i = 0; i < words.length; i++)
        {
            while (words[i].indexOf(prefix) != 0)
            {
                prefix = prefix.substring(0, prefix.length()-1);
            }

        }

        return prefix;


    }




    private static String longestPrefix(String[] strings) {

            if (strings.length == 0)
            {
                return "";
            }
            String prefix = strings[0];
            for (int i = 0; i < strings.length; i++)
            {
                while (strings[i].indexOf(prefix) != 0)
                {
                    prefix = prefix.substring(0, prefix.length()-1);
                }
            }
            return prefix;

    }
}
