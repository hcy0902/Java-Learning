public class Passenger {
    private String name;
    private int age = 8;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0)
        {
            this.age = age;
        }

    }
}
