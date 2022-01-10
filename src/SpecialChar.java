import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


//LC 20
public class SpecialChar {


    public static void main(String[] args) {
        System.out.println(isValid("(){}[]"));
    }

    public static boolean isValid(String s) {

       Map<Character, Character> paris = new HashMap<>();

       paris.put(')', '(');
        paris.put(']', '[');
        paris.put('}', '{');

        Stack<Character> open = new Stack<>();

        for (int i =0; i < s.length(); i++)
        {
            char temp = s.charAt(i);
            if (temp == '(' || temp == '[' || temp == '{')
            {
                open.push(temp);
            }
            else
            {
                if (paris.get(temp) != open.pop())
                {
                    return false;
                }

            }


        }

        if (open.size() == 0)
        {
            return true;
        }
        return false;

    }
}
