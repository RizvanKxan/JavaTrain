import Human.Human;
import Human.Builder;
import Human.Sailor;
import Human.Pilot;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

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
}
