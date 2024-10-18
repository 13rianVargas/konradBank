package co.edu.konradlorenz.model;

import java.time.LocalDate;

public class Cajero {

	private LocalDate fecha;

	public Cajero(LocalDate fecha) {
		super();
		this.fecha = fecha;
	}

	public Cajero() {
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public boolean verificarTarjeta(Tarjeta tarjeta) {
		return tarjeta.esTarjetaValida();
	}

	@Override
	public String toString() {
		return "Cajero [fecha=" + fecha + "]";
	}

}
