package Human;

import java.time.LocalDate;

public class Pilot extends Human {
    private boolean isFlying;

    public Pilot() {
        super();
    }

    public Pilot(String name, LocalDate age, String phone, String country, String city, String address) {
        super(name, age, phone, country, city, address);
        isFlying = true;
    }

    public boolean getIsFlying() {
        return isFlying;
    }

    public void setIsFlying(boolean isFlying) {
        this.isFlying = isFlying;
    }

    public void Fly() {
        if(isFlying) {
            System.out.println("I'm flying.");
        } else {
            System.out.println("I do not fly.");
        }
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "name='" + this.getFio() + '\'' +
                ", age=" + this.getAge() +
                ", phone='" + this.getPhone() + '\'' +
                ", country='" + this.getCountry() + '\'' +
                ", city='" + this.getCity() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                '}';
    }
}
