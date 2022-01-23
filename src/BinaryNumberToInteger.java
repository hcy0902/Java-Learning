import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumberToInteger {
    public static void main(String[] args) {


        
//        getDecimalValue(head);
        int binary = 101101;
        int result = 0;
        int pop = 0;
        int counter = 0;

        while (binary > 0)
        {
            pop = binary%10;
            result += Math.pow(2, counter) * pop;
            counter++;
            binary = binary/10;


        }

        System.out.println(result);



    }




}
