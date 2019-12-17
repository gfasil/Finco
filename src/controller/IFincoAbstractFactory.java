package controller;

import java.time.LocalDate;

import model.IAccount;
import model.ICustomer;
import model.IOperation;

public interface IFincoAbstractFactory {

	public ICustomer createCompany(String name, String email, String street, String city, String state, String zipcode,
			int numOfEmployees);

	public ICustomer createPerson(String name, String email, String street, String city, String state, String zipcode,
			LocalDate birthDate);

	public IAccount createAccount(ICustomer owner);

	public IOperation createOperation(String name, double amount, LocalDate timeStamp);
}
