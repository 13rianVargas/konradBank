package co.edu.konradlorenz.model;

public class Corriente extends Cuenta {
	private double limiteSobregiro;
    private double tasaSobregiro;
    private double sobregiroActual;

   
    public Corriente(String numeroCuenta, double saldo, String titular) {
        super(numeroCuenta, saldo, titular);
        this.limiteSobregiro = 50000.00;
        this.tasaSobregiro = 0.04; //4%
        this.sobregiroActual = 0;
    }

    public double getLimiteSobregiro() {
		return limiteSobregiro;
	}
    
	public double getTasaSobregiro() {
		return tasaSobregiro;
	}

	public double getSobregiroActual() {
		return sobregiroActual;
	}

	public void setSobregiroActual(double sobregiroActual) {
		this.sobregiroActual = sobregiroActual;
	}

	@Override
    public String toString() {
        return super.toString() + ", Tasa de Sobregiro: " + tasaSobregiro + ", Límite de Sobregiro: " + limiteSobregiro;
    }
}