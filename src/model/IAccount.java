package model;

import java.util.List;

public interface IAccount extends FincoObservable {

    public void setOwner(ICustomer customer);

    public void notifyObservers();

    public double getInterest();

    public void setInterest(double interest);

    public void addInterest();



	public boolean applyOperation(IOperation transaction);

	public double getBalance();

	public void setBalance(double balance);

	public String getAccountNumber();

    public List<IOperation> getTransactions();
}
