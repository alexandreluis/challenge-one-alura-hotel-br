package utilities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;



public class Calcular 
{
	public Long calculaTempoEmDias(Long tempoEmMilissegundos)
	{
		return tempoEmMilissegundos /1000 /60 /60 /24;
	}
}