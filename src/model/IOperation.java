package model;

import java.time.LocalDate;

public interface IOperation {
	public String description();
	public double getAmount();
	public LocalDate date();
}
