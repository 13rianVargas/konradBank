package co.edu.konradlorenz.model;

public class CuentaAhorro extends Cuenta {
    private double tasaInteres;

    
    public CuentaAhorro() {
        super();
    }

    public CuentaAhorro(String numeroCuenta, double saldo, String titular, double tasaInteres) {
        super(numeroCuenta, saldo, titular); 
        this.tasaInteres = tasaInteres;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public double calcularInteres() {
        return getSaldo() * tasaInteres; 
    }

    
    public void acreditarInteres() {
        double interes = calcularInteres();
        setSaldo(getSaldo() + interes); 
    }

    @Override
    public String toString() {
        return super.toString() + ", Tasa de Interés: " + tasaInteres;
    }
}