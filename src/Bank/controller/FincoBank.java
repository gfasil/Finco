package Bank.controller;

import Bank.view.BankWindow;
import controller.Finco;
import controller.FincoFactory;
import controller.IFincoAbstractFactory;
import model.IAccount;
import model.ICustomer;

import javax.swing.*;
import java.time.LocalDate;

public class FincoBank extends Finco {


    private IFincoAbstractFactory fincoSavingFactory;
    private IFincoAbstractFactory fincCheckingFactory;

    public FincoBank(IFincoAbstractFactory fincoFactory, IFincoAbstractFactory fincoSavingFactory, IFincoAbstractFactory fincCheckingFactory) {

        super(fincoFactory);

        this.fincoSavingFactory = fincoSavingFactory;
        this.fincCheckingFactory = fincCheckingFactory;
    }

    public void run() {
        try {
            // Add the following code if you want the Look and Feel
            // to be set to the Look and Feel of the native system.

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }

            // make an instance of application's frame visible.
            view = new BankWindow(this);
            view.initializeWindow();
            view.setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            // Ensure the application exits with an error condition.
            System.exit(1);
        }
    }


    public IAccount addCompanyAccount(String name, String email, String street, String city, String state,
                                      String zipcode, int numOfEmployees, String type) {
        ICustomer customer = fincoFactory.createCompany(name, email, street, city, state, zipcode, numOfEmployees);
        customer = findOrAddCustomer(customer);
        IAccount acc;
        if (type.equals("saving")) {
            acc = fincoSavingFactory.createAccount(customer);

        } else {
            acc = fincCheckingFactory.createAccount(customer);
        }
        acc.addObserver(view);
        customer.addAccount(acc);
        return acc;
    }

    public IAccount addPersonAccount(String name, String email, String street, String city, String state,
                                     String zipcode, LocalDate birthDate, String type) {
        ICustomer customer = fincoFactory.createPerson(name, email, street, city, state, zipcode, birthDate);
        customer = findOrAddCustomer(customer);
        IAccount acc;
        if (type.equals("saving")) {
            acc = fincoSavingFactory.createAccount(customer);
            System.out.println("inside if saving");
        } else {
            System.out.println("inside if checking");
            acc = fincCheckingFactory.createAccount(customer);
        }
        acc.addObserver(view);
        customer.addAccount(acc);
        return acc;
    }
    public  String generateReport() {
        String report = "";
        for (ICustomer c : customers) {
            report += "\nName = " + c.getName();
            report += "\nAddress = " + c.getAddress();
            report += "\nAccount = " + c.getAccountList();
            report += "\nTotal Balance = " + c.getAccountList().stream().mapToDouble(x -> x.getBalance()).sum();
            System.out.println(c.getName());

        }
        return report;
    }
    public static void main(String[] args) {
        Finco fincoApp = new FincoBank(new FincoFactory(),new FincoSavingFactory(), new FincoCheckingFactory());
        fincoApp.run();
    }
}
