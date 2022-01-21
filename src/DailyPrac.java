public class DailyPrac {

    public static void main(String[] args) {

        DailyPrac dailyPrac = new DailyPrac();

        System.out.println(dailyPrac.maxDistToClosest(new int[] {1,0,0,0}));
    }

    public int maxDistToClosest(int[] seats) {

        // L will be used to mark the last seen person
        int l = -1;
        int distance = 0;

        for (int i = 0; i < seats.length; i++)
        {
            if (seats[i] == 1)
            {
                if (l ==-1)
                {
                    distance = i;
                }
                else{
                    distance = Math.max(distance, (i-l)/2);
                }
                l = i;
            }
        }

        // last check for if the last seat is empty
        if (seats[seats.length-1] == 0)
        {
            distance = Math.max(distance, seats.length-1-l);
        }

        return distance;

    }
}
