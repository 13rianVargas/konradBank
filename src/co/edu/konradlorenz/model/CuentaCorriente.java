package co.edu.konradlorenz.model;

public class CuentaCorriente extends Cuenta {
    private double tasaSobregiro;
    private double limiteSobregiro;
    private double comisionMantenimiento;
    private double sobregiroActual;

   
    public CuentaCorriente(String numeroCuenta, double saldo, String titular, double tasaSobregiro, double limiteSobregiro, double comisionMantenimiento) {
        super(numeroCuenta, saldo, titular);
        this.tasaSobregiro = tasaSobregiro;
        this.limiteSobregiro = limiteSobregiro;
        this.comisionMantenimiento = comisionMantenimiento;
        this.sobregiroActual = 0;  
    }

    public void aplicarSobregiro(double monto) {
        if (sobregiroActual + monto > limiteSobregiro) {
            System.out.println("El monto excede el límite de sobregiro.");
        } else {
            sobregiroActual += monto;
            setSaldo(getSaldo() - monto);
            System.out.println("Sobregiro aplicado. Sobregiro actual: " + sobregiroActual);
        }
    }

    public void cobrarComision() {
        setSaldo(getSaldo() - comisionMantenimiento);
        System.out.println("Comisión de mantenimiento aplicada. Nuevo saldo: " + getSaldo());
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

    @Override
    public String toString() {
        return super.toString() + ", Tasa de Sobregiro: " + tasaSobregiro + ", Límite de Sobregiro: " + limiteSobregiro + ", Comisión de Mantenimiento: " + comisionMantenimiento;
    }
}