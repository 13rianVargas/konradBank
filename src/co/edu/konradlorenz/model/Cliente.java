package co.edu.konradlorenz.model;

public class Cliente implements Tarjeta {

	private String nombre;
	private long numeroCuenta;
	private long numeroDocumento;
	private String numeroTarjeta;
	private String pin;

	public Cliente(String nombre, long numeroCuenta, long numeroDocumento, String numeroTarjeta, String pin) {
		super();
		this.nombre = nombre;
		this.numeroCuenta = numeroCuenta;
		this.numeroDocumento = numeroDocumento;
		this.numeroTarjeta = numeroTarjeta;
		this.pin = pin;
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

	public long getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", numeroCuenta=" + numeroCuenta + ", numeroDocumento=" + numeroDocumento
				+ ", numeroTarjeta=" + numeroTarjeta + ", pin=" + pin + "]";
	}

	@Override
	public boolean esTarjetaValida() {
		int suma = 0;
		boolean alternar = false;

		for (int i = numeroTarjeta.length() - 1; i >= 0; i--) {
			int digito = Character.getNumericValue(numeroTarjeta.charAt(i));
			if (alternar) {
				digito *= 2;
				if (digito > 9) {
					digito -= 9;
				}
			}
			suma += digito;
			alternar = !alternar;
		}
		return suma % 10 == 0;
	}

	@Override
	public boolean verificarPIN(String pin) {

		return this.pin.equals(pin);
	}

}
