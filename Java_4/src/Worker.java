public class Worker {
    public String firstName;
    public String secondName;
    private int age;

    public Worker(String firstName, String secondName, int age ) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Работник {" +
                " Имя = '" + firstName + '\'' +
                ", Фамилия = '" + secondName + '\''+
                ", Возраст = '" + getAge() + '\'' +
                '}';
    }
}
