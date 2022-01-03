import java.util.HashMap;
import java.util.Map;

public class IsomorphicStr {

    public static void main(String[] args) {

        String first = "title";
        String second = "paper";
        System.out.println(isIsomorphic(first, second));
    }

    private static boolean isIsomorphic(String s, String t) {

        Map<Character, Character> mapping = new HashMap<>();
        Map<Character, Character> reversmapping = new HashMap<>();

        for (int i = 0; i < s.length(); i++)
        {
            char fc = s.charAt(i), sc = t.charAt(i);
            if (!mapping.containsKey(fc) && !mapping.containsKey(sc))
            {
                mapping.put(fc, sc);
                reversmapping.put(sc, fc);
            }
            else if(mapping.containsKey(fc) && mapping.get(fc) != sc)
            {
                return false;
            }
            else if(reversmapping.containsKey(sc) && reversmapping.get(sc) != fc)
        {
            return false;
        }
        }
        return true;

    }
}
