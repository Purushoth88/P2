package mvc.modelo;

import java.util.ArrayList;
import java.util.List;

import mvc.controlador.IObserver;

/*******************************************************************************
 * Modelo
 ******************************************************************************/

public class Cuenta implements ISubject {
	
	private static Cuenta cuenta;
	private List<IObserver> listObserves;
	
	private double saldo;

	private Cuenta(double si) {
		saldo = Math.max(0, si); // por simplificar ...
		listObserves = new ArrayList<>();
	}

	public void ingresa(double ing) {
		saldo += ing;
	}

	public double extrae(double extrae) { // limitado por saldo
		double realExtrae = extrae;
		if (saldo < extrae) {
			realExtrae = saldo;
		}
		saldo -= realExtrae;
		return realExtrae;
	}

	public double saldo() {
		return saldo;
	}
	
	public static Cuenta instancia(){
		if(cuenta==null){
			cuenta = new Cuenta(0.0);
		}
		
		return cuenta;
	}

	@Override
	public void addObserve(IObserver ob) {
		listObserves.add(ob);
	}

	@Override
	public void removeObserve(IObserver ob) {
		listObserves.remove(listObserves.indexOf(ob));
		
	}

	@Override
	public void notifyObserve() {
		for(IObserver ob : listObserves){
			ob.upDate(saldo);
		}
		
	}
}
