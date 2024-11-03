package co.edu.konradlorenz.controller;

import java.util.*;

import co.edu.konradlorenz.model.*;
import co.edu.konradlorenz.view.gui.KonradBank;


public class Controlador {
	
	private LinkedList<Cliente> listaClientes = new LinkedList<>();
	private LinkedList<Cuenta> listaCuentas = new LinkedList<>();
	public Cliente clienteSeleccionado;
	public Cuenta cuentaSeleccionada;

    public void run() {
    	@SuppressWarnings("unused")
    	KonradBank konradBank = new KonradBank();

    }
    //run
    
	public boolean validarCredenciales(String numeroTarjeta, String pin) {
		
		Cajero cajero = new Cajero();
		
		//Valida si la tarjeta es real
		if(!cajero.esTarjetaValida(numeroTarjeta)) {
			return false;
		}//*/
		
		//Valida si numeroTarjeta exite en listaClientes
		clienteSeleccionado = null;

		for (Cliente cliente : listaClientes) {
			if(cliente.getNumeroTarjeta().equals(numeroTarjeta)) {
				clienteSeleccionado = cliente;
				break;
			}
		}
		
		
		if(clienteSeleccionado==null) return false;
		
		//Valida si el pin corresponde al clienteSeleccionado
		boolean verificarPin = clienteSeleccionado.getPin().equals(pin) ? true : false;

		return verificarPin;
	}
	//validarCredenciales
    
    public void datosDePrueba() {
    	
    	/*/ TARJETAS
    	Tarjetas Válidas:
	    	4539 1488 0343 6467
			6011 1111 1111 1117
			5105 1051 0510 5100
			4111 1111 1111 1111
			3782 822463 10005
		Tarjetas Inválidas:
			4539 1488 0343 6468 
			6011 1111 1111 1113
			5105 1051 0510 5109
			4111 1111 1111 1112
			3782 822463 10006
    	//*/
    	
    	String nombreCompleto;
        String numeroCuenta;
        String numeroDocumento;
        String numeroTarjeta;
        String pin;
        double saldo; 
    	
        // Ejemplo 1
    	nombreCompleto = "Pepito Pérez";
    	numeroCuenta = "703213123";
        numeroDocumento = "1000123123";
        numeroTarjeta ="4539 1488 0343 6467" ;
        pin = "1234";
        saldo = 10000000.00;
        nuevoCliente(nombreCompleto, numeroCuenta, numeroDocumento, numeroTarjeta, pin);
        nuevoAhorro(numeroCuenta, saldo, nombreCompleto);

        // Ejemplo 2
        nombreCompleto = "Ana Torres";
        numeroCuenta = "402938475";
        numeroDocumento = "900123456";
        numeroTarjeta = "6011 1111 1111 1117";
        pin = "4567";
        saldo = 500000.00;
        nuevoCliente(nombreCompleto, numeroCuenta, numeroDocumento, numeroTarjeta, pin);
        nuevoAhorro(numeroCuenta, saldo, nombreCompleto);

        // Ejemplo 3
        nombreCompleto = "Luis Fernández";
        numeroCuenta = "301923847";
        numeroDocumento = "101928374";
        numeroTarjeta = "5105 1051 0510 5100";
        pin = "8910";
        saldo = 1000000.00;
        nuevoCliente(nombreCompleto, numeroCuenta, numeroDocumento, numeroTarjeta, pin);
        nuevaCorriente(numeroCuenta, saldo, nombreCompleto);

        // Ejemplo 4
        nombreCompleto = "Mariana Gómez";
        numeroCuenta = "504837291";
        numeroDocumento = "102837465";
        numeroTarjeta = "4111 1111 1111 1111";
        pin = "2468";
        saldo = 300.00;
        nuevoCliente(nombreCompleto, numeroCuenta, numeroDocumento, numeroTarjeta, pin);
        nuevaCorriente(numeroCuenta, saldo, nombreCompleto);
        
        // Ejemplo 5
        nombreCompleto = "Isolda Tristán";
        numeroCuenta = "739465027";
        numeroDocumento = "108365723";
        numeroTarjeta = "3782 822463 10005";
        pin = "9102";
        saldo = 50000000.00;
        nuevoCliente(nombreCompleto, numeroCuenta, numeroDocumento, numeroTarjeta, pin);
        nuevaCorriente(numeroCuenta, saldo, nombreCompleto);
        
    }
    //datosDePrueba
    
    public void nuevoCliente(String nombreCompleto, String numeroCuenta, String numeroDocumento, String numeroTarjeta, String pin) {
    	Cliente cliente = new Cliente(nombreCompleto, numeroCuenta, numeroDocumento, numeroTarjeta, pin);
    	listaClientes.add(cliente);
    }
    //nuevoCliente
    
    public void nuevoAhorro(String numeroCuenta, double saldo, String titular) {
    	Cuenta cuenta = new Ahorro(numeroCuenta, saldo, titular);
    	listaCuentas.add(cuenta);
    }
    //nuevoAhorro 
    
    public void nuevaCorriente(String numeroCuenta, double saldo, String titular) {
    	Cuenta cuenta = new Corriente(numeroCuenta, saldo, titular);
    	listaCuentas.add(cuenta);
    }
    //nuevaCorriente   
    
    public String obtenerNombrePorNumeroTarjeta(String numeroTarjeta) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getNumeroTarjeta().equals(numeroTarjeta)) {
                return cliente.getNombre(); 
            }
        }
        return null; 
    }
    //obtenerNombrePorNumeroTarjeta
    
    public void seleccionarCuenta() {
    	for (Cuenta cuenta : listaCuentas) {
            if (cuenta.getNumeroCuenta().equals(clienteSeleccionado.getNumeroCuenta())) {
                cuentaSeleccionada = cuenta;
            }
        }
    }
    //seleccionarCuenta
    

    
    public boolean depositarMonto(String monto) {
    	seleccionarCuenta();
    	
        try {
        	
            double deposito = Double.parseDouble(monto);
            if(deposito <= 0) return false; 
            double saldoActual = cuentaSeleccionada.getSaldo();
            
            cuentaSeleccionada.setSaldo(saldoActual + deposito);
            
            return true; 
        } catch (NumberFormatException e) {
            return false; 
        }
    }
    //depositarMonto
    
    public boolean retirarMonto(String monto) {
    	seleccionarCuenta();
    	
    	try {
    		double retiro = Double.parseDouble(monto);
    		if(retiro <= 0) return false;
    		double saldoActual = cuentaSeleccionada.getSaldo();
    		
    		if(cuentaSeleccionada.getSaldo() >= retiro) {
    		cuentaSeleccionada.setSaldo(saldoActual - retiro);
    		return true;}
    		else {
    			return false;
    		}
    	} catch (NumberFormatException e) {
    		return false;
    	}
    	
    }
    //retirarMonto
}
//class