package Human;

import java.time.LocalDate;

public class Sailor extends Human {
    private boolean isSailing;

    public Sailor() {
        super();
    }

    public Sailor(String name, LocalDate age, String phone, String country, String city, String address) {
        super(name, age, phone, country, city, address);
        isSailing = true;
    }

    public boolean getIsSailing() {
        return isSailing;
    }

    public void setIsSailing(boolean isSailing) {
        this.isSailing = isSailing;
    }

    public void Sailing() {
        if(isSailing) {
            System.out.println("I'm sailing.");
        } else {
            System.out.println("I do not sailing.");
        }
    }

    @Override
    public String toString() {
        return "Sailor{" +
                "name ='" + this.getFio() + '\'' +
                ", age =" + this.getAge() +
                ", phone ='" + this.getPhone() + '\'' +
                ", country ='" + this.getCountry() + '\'' +
                ", city ='" + this.getCity() + '\'' +
                ", address ='" + this.getAddress() + '\'' +
                '}';
    }
}
