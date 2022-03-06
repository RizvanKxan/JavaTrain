import java.time.LocalDate;

public class Worker {
    private static int globalID = 0;
    private final int ID;
    public String firstName;
    public String secondName;
    public boolean isFemale;
    private LocalDate age;
    private String phone;
    private Position position;
    private LocalDate dateOfReceipt;
    private int salary;

    public Worker(String firstName, String secondName, boolean isFemale, LocalDate age, String phone, Position position, LocalDate dateOfReceipt, int salary ) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.isFemale = isFemale;
        this.age = age;
        this.phone = phone;
        this.position = position;
        this.dateOfReceipt = dateOfReceipt;
        this.salary = salary;
        ID = globalID;
        globalID++;
    }

    public int getID() {
        return ID;
    }

    public LocalDate getAge() {
        return age;
    }

    @Override
    public String toString() {
        String gender;
        if (isFemale) {
            gender = "Женщина";
        }
        else gender = "Мужчина";

        return "Работник { " +
                " ID = '" + ID + '\'' +
                ", \n\t\t\tИмя = '" + firstName + '\'' +
                ", \n\t\t\tФамилия = '" + secondName + '\''+
                ", \n\t\t\tПол = '" + gender + '\''+
                ", \n\t\t\tДата рождения = '" + age + '\'' +
                ", \n\t\t\tТелефон = '" + phone + '\'' +
                ", \n\t\t\tДолжность = '" + position + '\'' +
                ", \n\t\t\tДата приёма = '" + dateOfReceipt + '\'' +
                ", \n\t\t\tЗарплата = '" + salary + '\'' +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
