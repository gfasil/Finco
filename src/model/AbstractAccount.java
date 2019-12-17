package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AbstractAccount implements IAccount {

    private List<FincoObserver<IAccount>> observers;
    private ICustomer owner;
    private List<IOperation> transactions;
    private double currentBalance;
    private double interest;
    private String accNumber;

    public AbstractAccount(ICustomer owner) {
        this.owner = owner;
        this.accNumber = UUID.randomUUID().toString();
        this.interest = 0.1;
        this.currentBalance = 0.0;
        observers = new ArrayList<>();
        observers.add(owner);
        transactions = new ArrayList<>();
    }

    @Override
    public void addObserver(FincoObserver<IAccount> ob) {
        observers.add(ob);
    }

    @Override
    public void removeObserver(FincoObserver<IAccount> ob) {
        observers.remove(ob);

    }

    @Override
    public void setOwner(ICustomer owner) {
        this.owner = owner;

    }

    @Override
    public void notifyObservers() {
        for (FincoObserver<IAccount> o : observers) {
            o.update(this); // review
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
        setBalance(getBalance() + (getBalance() * this.getInterest()));

    }


    @Override
    public boolean applyOperation(IOperation transaction) {
        this.transactions.add(transaction);
        double newBalance = getBalance() + transaction.getAmount();
        if (newBalance < 0) return false;
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
