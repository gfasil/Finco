package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Person extends AbstractCustomer implements  IPerson{
    private LocalDate birthdate;

    public Person(String name, String email, Address address, LocalDate birthDate) {
        super(name, email, address);
        this.birthdate = birthDate;
    }

    @Override
    public LocalDate getBirthDate() {
        return this.birthdate;
    }

    @Override
    public void setBirthDate(LocalDate birthDate) {
        this.birthdate = birthDate;
    }

}
