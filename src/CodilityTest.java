import java.util.ArrayList;
import java.util.List;

public class CodilityTest {

    public static void main(String[] args) {
        System.out.println(solution2(new int[]{1, 5, 5, 2, 6}));

    }

    public static String solution(String S, int K) {
        // write your code in Java SE 8
        int days = K%7;

        List<String> daysOfWeek = new ArrayList<String>();

        daysOfWeek.add("Mon");
        daysOfWeek.add("Tue");
        daysOfWeek.add("Wed");
        daysOfWeek.add("Thu");
        daysOfWeek.add("Fri");
        daysOfWeek.add("Sat");
        daysOfWeek.add("Sun");

        int index = daysOfWeek.indexOf(S)+1;


        if (days > (7-index))
        {
            days -= (7-index);
        }else
        {
            days+= index;
        }



        return daysOfWeek.get(days-1);






    }

    public static int solution2 (int[] blocks)
    {
        List<Integer> results = new ArrayList<>();
        for (int i = 1; i < blocks.length-1; i++)
        {
            int left = i;
            int right = i;
            while(left >=0 && right < blocks.length)
            {
                if (blocks[left-1] >= blocks[left])
                {
                    left--;
                }
                if (blocks[right+1] >= blocks[right])
                {
                    right++;
                }
                if(blocks[left-1] < blocks[left]
                        && blocks[right+1] < blocks[right])
                {
                    break;
                }
            }
            results.add(right-left+1);
        }

        int left = 0;
        int right = 0;
        while(right < blocks.length-1)
        {
            if (blocks[right+1] > blocks[right])
            {
                right++;
            }else
            {
                break;
            }
        }
        results.add(right-left+1);
        left = blocks.length-1;
        right = blocks.length-1;
        while(left >0)
        {
            if (blocks[left-1] > blocks[left])
            {
                left--;
            }
            else
            {
                break;
            }
        }
        results.add(right-left+1);

        int max = 0;
        for (Integer result:results)
        {
            max = Math.max(max, result);
        }

        return max;
    }

}
