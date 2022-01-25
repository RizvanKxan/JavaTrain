import java.util.ArrayList;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        People oneP = new People("Леонид","Громыко",City.GOMEL);
        People secondP = new People("Владимир","Ядченко", City.MINSK);
        People thirdP = new People("Сергей","Владилен", City.MINSK);
        Inspection.people.add(oneP);
        Inspection.people.add(secondP);
        Inspection.people.add(thirdP);
        oneP.addFines(TypeOfFine.PARKING);
        oneP.addFines(TypeOfFine.SPEED);
        secondP.addFines(TypeOfFine.SPEED);
        thirdP.addFines(TypeOfFine.CAR_ACCIDENT);
        System.out.println("Вывод всей базы:");
        System.out.println("**************************************************************************************");
        Inspection.printAll();
        System.out.println("**************************************************************************************");
        System.out.println("Вывод базы по id:");
        System.out.println("**************************************************************************************");
        Inspection.printByUUID(thirdP.getId());
        System.out.println("**************************************************************************************");
        System.out.println("Вывод базы по типу штрафа:");
        System.out.println("**************************************************************************************");
        Inspection.printByTypeFine(TypeOfFine.SPEED);
        System.out.println("**************************************************************************************");
        System.out.println("Вывод базы по городу:");
        System.out.println("**************************************************************************************");
        Inspection.printByCity(City.MINSK);

    }

    public static class Inspection {
        public static ArrayList<People> people = new ArrayList<People>();

        public static void printAll() {
            for(People p:people)
            {
                System.out.println(p);
            }
        }

        public static void printByUUID(UUID id) {
            for(People p:people)
            {
                if(p.getId() == id) {
                    System.out.println(p);
                }
            }
        }

        public static void printByTypeFine(TypeOfFine type) {
            for(People p:people)
            {
                if(p.getFines().contains(type)) {
                    System.out.println(p);
                }
            }
        }

        public static void printByCity(City city) {
            for(People p:people)
            {
                if(p.getCity() == city) {
                    System.out.println(p);
                }
            }
        }
    }

}
