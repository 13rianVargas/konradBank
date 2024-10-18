package co.edu.konradlorenz.model;

public class TarjetaDebito implements Tarjeta{
	
	private String numeroTarjeta;
	private String pin;
	
	public TarjetaDebito(String numeroTarjeta, String pin) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.pin = pin;
	}

	public TarjetaDebito() {
	}

	@Override
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	@Override
	public boolean verificarPIN(String pin) {
		
		return this.pin.equals(pin);
	}

	@Override
	public boolean esTarjetaValida() {
		int suma = 0;
		boolean alternar = false;
		
		for(int i = numeroTarjeta.length()-1; i >= 0; i--) {
			int digito = Character.getNumericValue(numeroTarjeta.charAt(i));
			if(alternar) {
				digito *= 2;
				if (digito>9) {
					digito -= 9;
				}
			}
			suma+= digito;
			alternar = !alternar;
		}
		return suma % 10==0;
	}

	@Override
	public String toString() {
		return "TarjetaCreditoDebito [numeroTarjeta=" + numeroTarjeta + ", pin=" + pin + "]";
	}
	
	
	
}
