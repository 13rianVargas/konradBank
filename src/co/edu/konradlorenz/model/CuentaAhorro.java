package co.edu.konradlorenz.model;

public class CuentaAhorro extends Cuenta {
    private double tasaInteres;
    private int limiteRetiros;
    private double saldoMinimo;
    private int retirosRealizados;  

   
    public CuentaAhorro(String numeroCuenta, double saldo, String titular, double tasaInteres, int limiteRetiros, double saldoMinimo) {
        super(numeroCuenta, saldo, titular);
        this.tasaInteres = tasaInteres;
        this.limiteRetiros = limiteRetiros;
        this.saldoMinimo = saldoMinimo;
        this.retirosRealizados = 0;  
    }

   
    public void realizarRetiro(double monto) {
        if (retirosRealizados >= limiteRetiros) {
            System.out.println("Has alcanzado el límite de retiros mensuales.");
        } else if (getSaldo() - monto < saldoMinimo) {
            System.out.println("No puedes retirar, el saldo caería por debajo del mínimo requerido.");
        } else {
            setSaldo(getSaldo() - monto);
            retirosRealizados++;
            System.out.println("Retiro realizado. Nuevo saldo: " + getSaldo());
        }
    }

    public void resetearRetirosMensuales() {
        retirosRealizados = 0;
    }

    
    public double calcularInteres() {
        return getSaldo() * tasaInteres;
    }

    public void acreditarInteres() {
        double interes = calcularInteres();
        setSaldo(getSaldo() + interes);
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tasa de Interés: " + tasaInteres + ", Límite de Retiros: " + limiteRetiros + ", Saldo Mínimo: " + saldoMinimo;
    }
}