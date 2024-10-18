package co.edu.konradlorenz.model;

public class Cliente {

	private String nombre;
	private long numeroCuenta;
	private long Cedula;

	public Cliente(String nombre, long numeroCuenta, long cedula) {
		super();
		this.nombre = nombre;
		this.numeroCuenta = numeroCuenta;
		Cedula = cedula;
	}

	public Cliente() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public long getCedula() {
		return Cedula;
	}

	public void setCedula(long cedula) {
		Cedula = cedula;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", numeroCuenta=" + numeroCuenta + ", Cedula=" + Cedula + "]";
	}
	
}
