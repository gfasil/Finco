package controller;

import java.time.LocalDate;

import model.IAccount;
import model.ICustomer;
import model.IOperation;

public interface IFincoAbstractFactory {
	public IAccount createAccount();

	public IOperation createOperation();

	public ICustomer createCompany(String name, String email, String street, String city, String state, String zipcode,
			int numOfEmployees);

	public ICustomer createPerson(String name, String email, String street, String city, String state, String zipcode,
			LocalDate birthDate);
}
