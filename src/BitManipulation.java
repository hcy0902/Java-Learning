public class BitManipulation {

    public static void main(String[] args) {
        BitManipulation bitManipulation = new BitManipulation();





        int n = 0b111101;
        System.out.println(bitManipulation.hammingWeight(n));

        //System.out.println(bitManipulation.isPowerOfTwo(15));
    }


    //LC 231 Power of Two

    public boolean isPowerOfTwo(int n)
    {

        boolean result;

        if (n == 0)
        {
            return false;
        }
        if (n == 1)
        {
            return true;
        }

        if (n%2 == 0)
        {
           result = isPowerOfTwo(n/2);

        }else
        {
            return false;
        }
       return result;

    }

    public int hammingWeight(int n) {

        int count = 0;
        while(n != 0) {
            int rsb = n & -n;
            n -= rsb;
            count++;
        }
        return count;

    }
}
