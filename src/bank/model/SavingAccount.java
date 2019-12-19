package bank.model;

import framework.model.AbstractAccount;
import framework.model.ICustomer;

public class SavingAccount extends AbstractAccount {

    public SavingAccount(ICustomer owner) {
        super(owner);

    }

    @Override
    public double getInterest() {
        return 0.1;
    }

    @Override
    public String getType() {
        return "SavingAccount";
    }
}
