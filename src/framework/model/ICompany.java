package framework.model;

public interface ICompany extends ICustomer {

	public void addPerson(IPerson person);
	public int employeeCount();
	public int getNoOfEmployees();
	public void setNoOfEmployees(int noOfEmployees);
}
