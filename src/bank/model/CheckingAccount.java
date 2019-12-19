package bank.model;

import framework.model.AbstractAccount;
import framework.model.ICustomer;

public class CheckingAccount extends AbstractAccount {

    public CheckingAccount(ICustomer owner) {
        super(owner);

    }

    @Override
    public double getInterest() {
        return 0.00967;
    }

    @Override
    public String getType() {
        return "CheckingAccount";
    }
}
