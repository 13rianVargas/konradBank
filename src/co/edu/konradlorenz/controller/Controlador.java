package co.edu.konradlorenz.controller;

import java.util.LinkedList;

import co.edu.konradlorenz.model.*;
import co.edu.konradlorenz.view.gui.KonradBank;


public class Controlador {
	
	LinkedList <Cliente> listaClientes = new LinkedList<>();	

    public void run() {
    	@SuppressWarnings("unused")
    	KonradBank konradBank = new KonradBank();

        datosDePrueba();
        
    }
    //run
    
	public boolean validarCredenciales(String numeroTarjeta, String pin) {
		
		Cajero cajero = new Cajero();
		
		//Valida si la tarjeta es real
		if(!cajero.esTarjetaValida(numeroTarjeta)) {
			return false;
		}
		
		//Valida si numeroTarjeta exite en listaClientes
		Cliente clienteSeleccionado = null;

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
    	
        // Ejemplo 1
    	nombreCompleto = "Pepito Pérez";
        numeroCuenta = "703213123";
        numeroDocumento = "1000123123";
        numeroTarjeta ="4539 1488 0343 6467" ;
        pin = "1234";
        nuevoCliente(nombreCompleto, numeroCuenta, numeroDocumento, numeroTarjeta, pin);

        // Ejemplo 2
        nombreCompleto = "Ana Torres";
        numeroCuenta = "402938475";
        numeroDocumento = "900123456";
        numeroTarjeta = "6011 1111 1111 1117";
        pin = "4567";
        nuevoCliente(nombreCompleto, numeroCuenta, numeroDocumento, numeroTarjeta, pin);

        // Ejemplo 3
        nombreCompleto = "Luis Fernández";
        numeroCuenta = "301923847";
        numeroDocumento = "101928374";
        numeroTarjeta = "5105 1051 0510 5100";
        pin = "8910";
        nuevoCliente(nombreCompleto, numeroCuenta, numeroDocumento, numeroTarjeta, pin);

        // Ejemplo 4
        nombreCompleto = "Mariana Gómez";
        numeroCuenta = "504837291";
        numeroDocumento = "102837465";
        numeroTarjeta = "4111 1111 1111 1111";
        pin = "2468";
        nuevoCliente(nombreCompleto, numeroCuenta, numeroDocumento, numeroTarjeta, pin);
        
        // Ejemplo 5
        nombreCompleto = "Isolda Tristán";
        numeroCuenta = "739465027";
        numeroDocumento = "108365723";
        numeroTarjeta = "3782 822463 10005";
        pin = "9102";
        nuevoCliente(nombreCompleto, numeroCuenta, numeroDocumento, numeroTarjeta, pin);
        
    }
    //datosDePrueba
    
    public Cliente nuevoCliente(String nombreCompleto, String numeroCuenta, String numeroDocumento, String numeroTarjeta, String pin) {
    	Cliente cliente = new Cliente(nombreCompleto, numeroCuenta, numeroDocumento, numeroTarjeta, pin);
    	listaClientes.add(cliente);
    	return cliente;
    }
    //nuevoCliente
 
}
//class