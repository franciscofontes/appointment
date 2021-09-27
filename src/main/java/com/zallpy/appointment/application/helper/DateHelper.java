package com.zallpy.appointment.application.helper;

public class DateHelper {

	public String getHoras(Integer minutos) {
		if (minutos != null) {
			int h = minutos / 60;
			int m = minutos % 60;
			return String.format("%d:%02d", h, m);
		}
		return "00:00";
	}
}
