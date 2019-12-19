package framework.model;

public interface FincoObservable<T> {

	public void addObserver(FincoObserver<T> ob);

	public void removeObserver(FincoObserver<T> ob);

	public void notifyObservers();
}
