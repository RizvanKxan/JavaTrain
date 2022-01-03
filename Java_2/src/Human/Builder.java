package Human;

import java.time.LocalDate;

public class Builder extends Human {
    private boolean isBuild;

    public Builder() {
        super();
    }

    public Builder(String name, LocalDate age, String phone, String country, String city, String address) {
        super(name, age, phone, country, city, address);
        isBuild = true;
    }

    public boolean getIsBuild() {
        return isBuild;
    }

    public void setIsBuild(boolean isBuild) {
        this.isBuild = isBuild;
    }

    public void Build() {
        if (isBuild) {
            System.out.println("I'm build.");
        } else {
            System.out.println("I do not building.");
        }
    }

    @Override
    public String toString() {
        return "Builder{" +
                "name='" + this.getFio() + '\'' +
                ", age=" + this.getAge() +
                ", phone='" + this.getPhone() + '\'' +
                ", country='" + this.getCountry() + '\'' +
                ", city='" + this.getCity() + '\'' +
                ", address='" + this.getAddress() + '\'' +
                '}';
    }
}

