package br.com.vitt.sipedy.services.Formatters;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

	public static Date converteStringParaDate(String dataString) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return format.parse(dataString);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String converteDateParaString(Date data) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		try {
			return format.format(data);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String converteDateParaStringHorario(Date data) {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		try {
			return format.format(data);
		} catch (Exception e) {
			return null;
		}
	}

}
