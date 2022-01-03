public class LeetCode {

    public static boolean countHi(String str) {

        String test  = "javaquestion";
        boolean cat = false;
        boolean dog = false;
        //to get cat
        while(str.length()>=3 )
        {
            if (str.substring(0,3).equals("cat") || str.substring(0,3).equals("dog")) {
                if (str.substring(0,3).equals("cat"))
                {
                    cat = true;
                    str = str.substring(1);
                }else {
                    dog = true;
                    str = str.substring(1);
                }

            } else
                str = str.substring(1);
        }

        if (dog && cat)
        {
            return true;
        }
        return false;
    }

    public static boolean checkXYZ(String str){

        String temp = "a";
        while(str.length()>=3)
        {
            if (str.substring(0,3).equalsIgnoreCase("xyz"))
            {
                if (!temp.equals("."))
                {
                    return true;
                }
                return false;
            }else
            {
                temp = str.substring(0,1);
                str = str.substring(1);
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        //System.out.println(countHi("23dogasfjksdcat "));
        System.out.println(checkXYZ("xyz.abc"));
    }
}
