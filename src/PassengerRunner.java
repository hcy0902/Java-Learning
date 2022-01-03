public class PassengerRunner {

    public static void main(String[] args) {

        Passenger firstPassenger = new Passenger();

        firstPassenger.setName("John");
        firstPassenger.setAge(-20);

        String message = "What is showing here %s %s end";

        String a = "first";
        String b = "Second";

        System.out.println(String.format(message, a, b));


        System.out.println(firstPassenger.getName());
        System.out.println(firstPassenger.getAge());

    }
}
