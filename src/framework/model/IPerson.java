package framework.model;

import java.time.LocalDate;

public interface IPerson extends ICustomer  {

	public LocalDate getBirthDate();
	public void setBirthDate(LocalDate birthDate);

	public double getLimit();

	public void setLimit(double limit);
}
