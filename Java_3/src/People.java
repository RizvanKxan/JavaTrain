import java.util.ArrayList;
import java.util.UUID;


public class People {
    private UUID id;
    private String firstName;
    private String secondName;
    private City city;
    private ArrayList<TypeOfFine> fines = new ArrayList<TypeOfFine>();
    public People() {
        id = UUID.randomUUID();
    }
    public People(String firstName, String secondName, City city) {
        id = UUID.randomUUID();
        this.firstName = firstName;
        this.secondName = secondName;
        this.city = city;
    }
    public UUID getId() {
        return id;
    }
    public City getCity() {
        return city;
    }
    public ArrayList<TypeOfFine> getFines() {

        return fines;
    }
    public void addFines(TypeOfFine type) {
        fines.add(type);

    }
    public void removeFines(TypeOfFine type) {
        fines.remove(type);

    }
    @Override
    public String toString() {
        return "ID: " + id
                + ", Имя: " + firstName
                + ", Фамилия: " + secondName
                + ", Город: " + city
                + ", Штрафы: " + fines;
    }

}
