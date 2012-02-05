package aeecommerce.utils;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DateUtils {
	public static final String DATE_FORMAT_NOW = "dd/mm/yyyy";

	public static Date now() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return new Date(sdf.format(cal.getTime()));

	}

	public static void  main(String arg[]) {
		System.out.println("Now : " + DateUtils.now());
	}
}