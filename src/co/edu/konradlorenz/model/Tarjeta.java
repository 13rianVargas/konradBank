package co.edu.konradlorenz.model;

public interface Tarjeta {
	
	String getNumeroTarjeta();
	boolean verificarPIN(String pin);
	boolean esTarjetaValida();
}
