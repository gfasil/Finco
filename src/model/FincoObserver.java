package model;

@FunctionalInterface
public interface FincoObserver {

    <T> void update(FincoObservable o, T arg);



}
