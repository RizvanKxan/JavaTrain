import java.util.ArrayList;
import java.util.UUID;


public class People {
    private UUID id;
    private String firstName;
    private String secondName;
    private ArrayList<TypeOfFine> fines = new ArrayList<TypeOfFine>();
    public People() {
        id = UUID.randomUUID();
    }
    public People(String firstName, String secondName) {
        id = UUID.randomUUID();
        this.firstName = firstName;
        this.secondName = secondName;
    }
    public UUID getId() {
        return id;
    }
    public void getFines() {
        if(fines.size() > 0) {
            for(TypeOfFine fine : fines){
                System.out.println(fine);
            }
        }
        else {
            System.out.println("Штрафов нет.");
        }

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
                + ", Штрафы: " + fines;
    }

}
