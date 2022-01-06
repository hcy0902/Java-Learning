import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class assessment {
    public static void main(String[] args) {
        Integer[] arrInt= {3,3,6,8,10};
        int desiredNum = 18;
        //take first number , sum with rest of the numbers one by one,
        // if that is equal to 12 then return true else false


        //check if the FIRST num add up any number to be the desired
        System.out.println(checkSum(arrInt, desiredNum));


        //check if any two number added up to be the desired
      //  System.out.println(Arrays.toString(getDesiredNumber(arrInt, desiredNum)));

        Map <Integer, Integer> numbers = new HashMap<>();

        for (int i = 0; i < arrInt.length; i++)
        {
            if (numbers.containsKey(desiredNum-arrInt[i]))
            {
                System.out.println("found" + (desiredNum - arrInt[i]) + " and " + arrInt[i]);
            }else
            {
                numbers.put(arrInt[i], i);
            }
        }


    }

    private static boolean checkSum(Integer[] arrInt, int desiredNumber) {
        Integer firstNum = arrInt[0];
        Integer sum = firstNum;
        for (int i = 1; i < arrInt.length; i++)
        {
            sum += arrInt[i];
            if (sum == desiredNumber)
            {
                return true;
            }
            sum = firstNum;
        }
        return false;
    }

    public static int[] getDesiredNumber (Integer[] arrn, int desiredNumber){

        Map<Integer, Integer> storedNums = new HashMap<>();
        for(int i=0; i<arrn.length; i++) {
          if (storedNums.containsKey(desiredNumber - arrn[i]))
          {
              return new int[]{arrn[i], desiredNumber - arrn[i]};
          }
          else
          {
              storedNums.put(arrn[i], i);
          }
        }
        return new int[]{};
    }

}
