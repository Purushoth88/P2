package mvc.modelo;

import mvc.controlador.IObserver;

public interface ISubject {
	
	void addObserve( IObserver ob);
	void removeObserve(IObserver ob);
	void notifyObserve();

}
