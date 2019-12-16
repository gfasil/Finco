package model;

import java.util.ArrayList;
import java.util.List;

public class AbstractAccount implements IAccount {

    private List<FincoObserver> observers;
    private ICustomer owner;
    private List<IOperation> transactions;
    private double currentBalance;
    private double interest;
    private String accNumber;

        public AbstractAccount(ICustomer owner,  double interest,String accNumber){

            this.owner=owner;
            this.accNumber=accNumber;
            this.interest=interest;
            this.currentBalance=0.0;
             observers=new ArrayList<>();
            transactions=new ArrayList<>();
        }
    @Override
    public void addObserver(FincoObserver ob) {
        observers.add(ob);
    }

    @Override
    public void removeObserver(FincoObserver ob) {
        observers.remove(ob);

    }

    @Override
    public void setOwner(ICustomer owner) {
        this.owner = owner;

    }

    @Override
    public void notifyObservers() {
        for (FincoObserver temp : observers) {

            temp.update(this, ""); // review
        }

    }

    @Override
    public double getInterest() {
        return this.interest;
    }

    @Override
    public void setInterest(double interest) {
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "accountNumber: " + accNumber + ", currentBalance: " + currentBalance;
    }

    @Override
    public void addInterest() {
        setBalance( getBalance()+ (getBalance() * this.getInterest()));

    }


    @Override
    public boolean applyOperation(IOperation transaction) {
        this.transactions.add(transaction);
        double newBalance=getBalance() + transaction.getAmount();
        if(newBalance<0) return false;
        setBalance(newBalance);
        return true;

    }

    @Override
    public double getBalance() {
        return this.currentBalance;
    }

    @Override
    public void setBalance(double balance) {
        this.currentBalance = balance;
    }


    @Override
    public String getAccountNumber() {
        return this.accNumber;
    }


    @Override
    public List<IOperation> getTransactions() {
        return this.transactions;
    }
}
