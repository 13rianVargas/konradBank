package co.edu.konradlorenz.model;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cajero {


	public boolean verificarTarjeta(Tarjeta tarjeta) {
		return tarjeta.esTarjetaValida();
	}

	private String getActualTime(){
		LocalDateTime fechaHoraActual = LocalDateTime.now(); //Formato de LocalDate Time: YYYY-MM-DDTHH:MM:SS
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); //Formato más agradable a la vista.
		String actualTime = fechaHoraActual.format(formato);
		return actualTime;
	}

}
