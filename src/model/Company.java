package model;

public class Company extends AbstractCustomer implements ICompany {
    public Company(String name, String email, Address address) {
        super(name, email, address);
    }

    @Override
    public void addPerson(IPerson person) {

    }

    @Override
    public int employeeCount() {
        return 0;
    }

    @Override
    public int getNoOfEmployees() {
        return 0;
    }

    @Override
    public void setNoOfEmployees(int noOfEmployees) {

    }

    @Override
    public Address setAddress() {
        return null;
    }
}
