package model;

import java.util.Date;

public interface IPerson extends ICustomer {

	public Date getBirthDate();
	public void setBirthDate(Date birthDate);
}
