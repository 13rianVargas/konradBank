package co.edu.konradlorenz.model;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cajero implements Tarjeta{
	
	private String getActualTime(){
		LocalDateTime fechaHoraActual = LocalDateTime.now(); //Formato de LocalDate Time: YYYY-MM-DDTHH:MM:SS
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy"); //Formato más agradable a la vista.
		String actualTime = fechaHoraActual.format(formato);
		return actualTime;
	}
	
	@Override
	public boolean esTarjetaValida(String numeroTarjeta) {
		int suma = 0;
		boolean alternar = false;

		for (int i = numeroTarjeta.length() - 1; i >= 0; i--) {
			int digito = Character.getNumericValue(numeroTarjeta.charAt(i));
			if (alternar) {
				digito *= 2;
				if (digito > 9) {
					digito -= 9;
				}
			}
			suma += digito;
			alternar = !alternar;
		}
		return suma % 10 == 0;
	}

}
