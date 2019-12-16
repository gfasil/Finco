package model;

public  interface FincoObservable {

    public void addObserver(FincoObserver ob);

    public void removeObserver(FincoObserver ob);
    public void notifyObservers();
}
