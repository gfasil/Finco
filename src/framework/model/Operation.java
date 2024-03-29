package framework.model;

import java.time.LocalDateTime;

public class Operation implements IOperation {
    private String name;
    private double amount;
    private LocalDateTime timeStamp;

    public Operation(String name, double amount){
        this.name = name;
        this.amount = amount;
        this.timeStamp = LocalDateTime.now();
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public LocalDateTime getTimestamp() {
        return timeStamp;
    }

    @Override
    public double getAmount() {
        return amount;
    }

}