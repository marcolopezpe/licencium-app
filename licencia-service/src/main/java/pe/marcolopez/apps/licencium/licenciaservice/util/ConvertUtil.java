package pe.marcolopez.apps.licencium.licenciaservice.util;

import java.time.LocalDate;
import java.time.ZoneId;

public class ConvertUtil {

    public static LocalDate convertToLocalDate(long epochDay) {
        return LocalDate.ofEpochDay(epochDay);
    }

    public static long convertToEpochDay(LocalDate localDate) {
        return localDate.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
    }
}
