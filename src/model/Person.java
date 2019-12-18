package model;

import java.time.LocalDate;

public class Person extends AbstractCustomer implements IPerson {
    private LocalDate birthdate;
    private double limit;

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public Person(String name, String email, Address address, LocalDate birthDate, int limit) {
        super(name, email, address);
        this.birthdate = birthDate;
        this.limit = limit;
    }

    @Override
    public LocalDate getBirthDate() {
        return this.birthdate;
    }


    @Override
    public void setBirthDate(LocalDate birthDate) {
        this.birthdate = birthDate;
    }

    @Override
    public void update(IAccount acc) {
        // to be done
        this.sendEmail("Account updated, new balance:" + acc.getBalance());
    }

    @Override
    public String getType() {
        return "Person";
    }

    @Override
    public boolean validateOperation(IAccount account, IOperation operation) {
        return Math.abs(operation.getAmount()) < getLimit() && account.getBalance() + operation.getAmount() >= 0;
    }
}
