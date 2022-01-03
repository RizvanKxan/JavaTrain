package Human;

import java.time.LocalDate;

public class Human {
    public static int countHuman;
    private String fio;
    private LocalDate age;
    private String phone;
    private String country;
    private String city;
    private String address;

    public Human() {
        countHuman++;
    }

    public Human(String name, LocalDate age, String phone, String country, String city, String address) {
        this.fio = name;
        this.age = age;
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.address = address;
        countHuman++;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public LocalDate getAge() {
        return age;
    }

    public void setAge(LocalDate age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void countHumans() {
        System.out.println("Human count = " + countHuman);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + getFio() + '\'' +
                ", age=" + getAge() +
                ", phone='" + getPhone() + '\'' +
                ", country='" + getCountry() + '\'' +
                ", city='" + getCity() + '\'' +
                ", address='" + getAddress() + '\'' +
                '}';
    }
}
