public class LeetCodeDaily {


    //LC 67
    public static void main(String[] args) {

        LeetCodeDaily leetCode = new LeetCodeDaily();
        System.out.println(addBinary("101", "11"));
    }


    //LC 67  Add binary
    public static String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;

        //we wanna loop through until both of them is ended
        while(i >= 0 || j >=0)
        {
            //every new iteration, we reset sum to be carry from the last iteration
            int sum = carry;

            // do this to convery the char to an int, and add a's index to sum
            if (i >=0) sum+= a.charAt(i) - '0';
            if (j >=0) sum+= b.charAt(j) - '0';
            //if sum is 2, append 0, meaning carry over to next iteration, if not, append 1 or 0
            sb.append(sum%2);
            // carry is sum/2
            carry = sum/2;

            i--;
            j--;

        }

        // if left over carry found, we append it to sb
        if (carry != 0)
        {
            sb.append(carry);
        }

        //need to reverse it because stringbuilder add it to the end
        return sb.reverse().toString();


    }

    public static long binarayToDecimal(long n)
    {

        long pop = 0;
        int counter = 0;
        long temp = 0;
        while(n>0)
        {
            pop = n%10;
            n = n/10;
            temp += pop * Math.pow(2, counter);
            counter++;
        }

        return temp;

    }
}
