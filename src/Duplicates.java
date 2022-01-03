import java.util.*;

public class Duplicates {
    public static void main(String[] args) {
        String name = "I am am a good Good dancer";


        //System.out.println(name);
        List<String> words = Arrays.stream(name.split(" ")).toList();
        Map<String, Integer> wordMap = new HashMap<String, Integer>();

        List<String> uniqueWords = new ArrayList<String>();



        for (int i = 0; i < words.size(); i++) {

            if (!uniqueWords.contains(words.get(i).toLowerCase()))
            {
                uniqueWords.add(words.get(i));
            }
        }

        String newWord = uniqueWords.toString();
        System.out.println(uniqueWords);





        //System.out.print(words);




    }
}
