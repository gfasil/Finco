package model;

public class Account extends AbstractAccount {

    public Account(ICustomer owner) {
        super(owner);

    }
    @Override
    public double getInterest() {
        return 0.1;
    }

	@Override
	public String getType() {
		return "Account";
	}
}
