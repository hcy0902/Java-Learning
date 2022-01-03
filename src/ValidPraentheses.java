import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidPraentheses {

    public static void main(String[] args) {
        System.out.println(isValid("([){]}()"));

        String s = "12345";
        String s2 = "1234";
        char c = s.charAt(2);
        System.out.println(s.length()%2);
        System.out.println(s2.length()%2);
    }

    private static boolean isValid(String s) {
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')','(');
        pairs.put(']','[');
        pairs.put('}','{');
        char[] symbols = s.toCharArray();

        Stack<Character> record = new Stack<>();

        for (char x:symbols)
        {

            if (x == '(' || x=='{' || x=='[')
            {
                record.push(x);
            }
            else if (record.size() == 0 && (x == ')' || x == ']' || x == '}' ))
            {
                return false;
            }
            else if (record.size()>0 && pairs.get(x) != record.pop())
            {
                return false;
            }

        }

        if (record.size() == 0)
        {
            return true;
        }



        return false;
    }
}
