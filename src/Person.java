import java.time.LocalDate;

public class Person {

    private String name,
        adress,
        phone_number;
    private LocalDate birth_date;

    public Person(String name, String adress, String phone_number, LocalDate birth_date) {

        this.name = name;
        this.adress = adress;
        this.phone_number = phone_number;
        this.birth_date = birth_date;

    }

    public String getName() {return this.name;}
    public String getAdress() {return this.adress;}
    public String getPhoneNumber() {return this.phone_number;}
    public LocalDate getBirthDate() {return this.birth_date;}

    public void updateAdress(String adress) {this.adress = adress;}
    public void updatePhoneNumber(String phone_number) {this.adress = adress;}

}
