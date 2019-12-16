package model;

import java.time.LocalDate;

public class Operation implements IOperation {
    private String name;
    private double amount;
    private LocalDate timeStamp;

    public Operation(String name, double amount, LocalDate timeStamp){
        this.name = name;
        this.amount = amount;
        this.timeStamp = timeStamp;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getTimestamp() {
        return null;
    }

    @Override
    public double getAmount() {
        return 0;
    }

}