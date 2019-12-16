package controller;

import java.util.ArrayList;
import java.util.List;

import model.ICustomer;

public class Finco {

	private static List<ICustomer> customers = new ArrayList<ICustomer>();
	
	private static IFincoAbstractFactory personAccountFactory = new FincoPersonFactory();

	private static IFincoAbstractFactory companyAccountFactory = new FincoCompanyFactory();

	public static void addCompanyAccount() {
		
	}
	
	public static void addPersonAccount() {

	}
	
	public static void addAccountOperation() {
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
