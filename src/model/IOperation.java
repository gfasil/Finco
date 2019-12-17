package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface IOperation {
	public String getName();

	public LocalDateTime getTimestamp();

	public double getAmount();
}
