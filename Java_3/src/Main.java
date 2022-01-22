import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        People oneP = new People("Леонид","Громыко");
        People secondP = new People("Владимир","Ядченко");
        Inspection.people.add(oneP);
        Inspection.people.add(secondP);
        oneP.addFines(TypeOfFine.PARKING);
        oneP.addFines(TypeOfFine.SPEED);
        System.out.println(oneP);

    }

    public static class Inspection {
        public static ArrayList<People> people = new ArrayList<People>();
        //public static HashMap<TypeOfFine, ArrayList<People>> map;

    }

}
