package model.personel_employee;

public interface Subject {

	public void registerObserver(DraftObserverInterface o);

	public void removeObserver(DraftObserverInterface o);

	public void notifyObservers(DraftObserverInterface o);
}
