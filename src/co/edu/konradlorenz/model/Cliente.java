package co.edu.konradlorenz.model;

public class Cliente {

	private String nombreCompleto;
	private String numeroCuenta;
	private String numeroDocumento;
	private String numeroTarjeta;
	private String pin;

	public Cliente(String nombreCompleto, String numeroCuenta, String numeroDocumento, String numeroTarjeta, String pin) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.numeroCuenta = numeroCuenta;
		this.numeroDocumento = numeroDocumento;
		this.numeroTarjeta = numeroTarjeta;
		this.pin = pin;
	}

	public Cliente() {

	}

	public String getNombre() {
		return nombreCompleto;
	}

	public void setNombre(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
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
		return "Cliente [nombre=" + nombreCompleto + ", numeroCuenta=" + numeroCuenta + ", numeroDocumento=" + numeroDocumento
				+ ", numeroTarjeta=" + numeroTarjeta + ", pin=" + pin + "]";
	}

}
