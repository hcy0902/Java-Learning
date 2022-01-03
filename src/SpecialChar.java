public class SpecialChar {


    public static void main(String[] args) {
        System.out.println(isValid("({)}"));
    }

    public static boolean isValid(String s) {

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(')
            {
                if (!(s.charAt(i+1) == ')'))
                {
                    return false;
                }

            }

            if (s.charAt(i) == '[')
            {
                if (!(s.charAt(i+1) == ']'))
                {
                    return false;
                }

            }
            if (s.charAt(i) == '{')
            {
                if (!(s.charAt(i+1) == '}'))
                {
                    return false;
                }

            }
        }

        return true;

    }
}
