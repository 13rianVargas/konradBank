package co.edu.konradlorenz.model;

public class CuentaCredito extends Cuenta {
    private double limiteCredito;
    private double deuda;

    public CuentaCredito(String numeroCuenta, double saldo, String titular, double limiteCredito, double deuda) {
        super(numeroCuenta, saldo, titular);
        this.limiteCredito = limiteCredito;
        this.deuda = deuda;
    }

    public void pagarCredito(double monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser positivo.");
        } else if (monto > deuda) {
            System.out.println("El monto excede la deuda actual.");
        } else {
            deuda -= monto; 
            System.out.println("Pago realizado. Deuda restante: " + deuda);
        }
    }

    public void usarCredito(double monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser positivo.");
        } else if (monto > (limiteCredito - deuda)) {
            System.out.println("El monto excede el límite de crédito disponible.");
        } else {
            deuda += monto; 
            System.out.println("Crédito utilizado. Nueva deuda: " + deuda);
        }
    }

    
    public double calcularDeuda() {
        return deuda;
    }

  
    public double consultarLimite() {
        return limiteCredito;
    }

    @Override
    public String toString() {
        return super.toString() + ", Límite de Crédito: " + limiteCredito + ", Deuda: " + deuda;
    }
}