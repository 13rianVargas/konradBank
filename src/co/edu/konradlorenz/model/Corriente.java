package co.edu.konradlorenz.model;

public class Corriente extends Cuenta {
    private double tasaSobregiro;
    private double limiteSobregiro;
    private double comisionMantenimiento;
    private double sobregiroActual;

   
    public Corriente(String numeroCuenta, double saldo, String titular, double tasaSobregiro, double limiteSobregiro, double comisionMantenimiento) {
        super(numeroCuenta, saldo, titular);
        this.tasaSobregiro = tasaSobregiro;
        this.limiteSobregiro = limiteSobregiro;
        this.comisionMantenimiento = comisionMantenimiento;
        this.sobregiroActual = 0;  
    }

    

    public double getTasaSobregiro() {
        return tasaSobregiro;
    }

    public void setTasaSobregiro(double tasaSobregiro) {
        this.tasaSobregiro = tasaSobregiro;
    }

    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public void setLimiteSobregiro(double limiteSobregiro) {
        this.limiteSobregiro = limiteSobregiro;
    }

    public double getComisionMantenimiento() {
        return comisionMantenimiento;
    }

    public void setComisionMantenimiento(double comisionMantenimiento) {
        this.comisionMantenimiento = comisionMantenimiento;
    }
    

    public double getSobregiroActual() {
		return sobregiroActual;
	}

	public void setSobregiroActual(double sobregiroActual) {
		this.sobregiroActual = sobregiroActual;
	}

	@Override
    public String toString() {
        return super.toString() + ", Tasa de Sobregiro: " + tasaSobregiro + ", Límite de Sobregiro: " + limiteSobregiro + ", Comisión de Mantenimiento: " + comisionMantenimiento;
    }
}