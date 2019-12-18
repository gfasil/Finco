package controller;

import model.Address;
import model.IAccount;
import model.ICustomer;
import model.IOperation;

import java.time.LocalDate;

public interface IFincoAbstractFactory {

	public ICustomer createCompany(String name, String email, String street, String city, String state, String zipcode,
			int numOfEmployees);

	public ICustomer createPerson(String name, String email, String street, String city, String state, String zipcode,
			LocalDate birthDate);

	public IAccount createAccount(ICustomer owner);
	public Address createAddress(String street, String city, String state, String zipcode);

	public IOperation createOperation(String name, double amount);
}
