package model;

public class Company extends AbstractCustomer implements ICompany {

    private int numberOfEmployees;
    public Company(String name, String email, Address address) {
        super(name, email, address);
    }

    @Override
    public void addPerson(IPerson person) {

    }

    @Override
    public int employeeCount() {
        return numberOfEmployees;
    }

    @Override
    public int getNoOfEmployees() {
        return numberOfEmployees;
    }

    @Override
    public void setNoOfEmployees(int noOfEmployees) {
        this.numberOfEmployees=noOfEmployees;
    }


    @Override
    public void update(IAccount acc) {
        // to be done
        this.sendEmail("Account updated, new balance:" + acc.getBalance());
    }
}
