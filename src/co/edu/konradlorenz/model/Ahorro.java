package co.edu.konradlorenz.model;

public class Ahorro extends Cuenta {
    private int limiteRetiros;
   
    public Ahorro(String numeroCuenta, double saldo, String titular) {
        super(numeroCuenta, saldo, titular);
        this.limiteRetiros  = 15;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tasa de Interés: " + ", Límite de Retiros: " + limiteRetiros ;
    }
}