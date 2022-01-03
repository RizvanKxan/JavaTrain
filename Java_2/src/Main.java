import Array.Array;
import Human.Human;
import Human.Builder;
import Human.Sailor;
import Human.Pilot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws IOException {
        int choice;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            choice = 0;
            System.out.println("Выберите что хотите посмотреть: ");
            System.out.println("1. Класс Human и его наследники.");
            System.out.println("2. Интерфейс IMath и его имплементация в классе Array.");
            System.out.println("3. Выход.");
            System.out.print("Ваш выбор: ");
            choice = Integer.parseInt(reader.readLine());
            switch (choice) {
                case 1: {
                    System.out.println("*************************************");
                    Builder builder = new Builder("MarkBuilder", LocalDate.of(1995, 12, 2), "1222222", "Belarus", "Minsk", "str. K.Marks, 12");
                    builder.Build();
                    System.out.println(builder);
                    System.out.println("*************************************");

                    Sailor sailor = new Sailor("MarkSailor", LocalDate.of(1995, 12, 2), "2222222", "Belarus", "Minsk", "str. K.Marks, 22");
                    sailor.Sailing();
                    System.out.println(sailor);
                    System.out.println("*************************************");

                    Pilot pilot = new Pilot("MarkPilot", LocalDate.of(1995, 12, 2), "3222222", "Belarus", "Minsk", "str. K.Marks, 32");
                    sailor.Sailing();
                    System.out.println(pilot);
                    System.out.println("*************************************");

                    Human.countHumans();
                }
                break;
                case 2: {
                    Array mass = new Array(10);
                    System.out.print("Наш сгенерированный массив: ");
                    mass.printArray();
                    System.out.println("Максимум в массиве: " + mass.Max());
                    System.out.println("Минимум в массиве: " + mass.Min());
                    System.out.println("Среднее арифметическое массива: " + mass.Avg());
                }
                break;
                default:
                    break;
            }

        } while (choice != 3);

    }
}
