package co.edu.konradlorenz.model;

public abstract class Cuenta {
	private String numeroCuenta;
	private double saldo;
	private String titular;
	
	public Cuenta() {
	}

	public Cuenta(String numeroCuenta, double saldo, String titular) {
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.titular = titular;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public void depositar (double monto) {
		 setSaldo(getSaldo() + monto);
	}
	
	public void retirar (double monto) {
		setSaldo(getSaldo() - monto);
	}
	

	@Override
	public String toString() {
		return "Cuenta [numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + ", titular=" + titular + "]";
	}
	
	

	
	
}	
