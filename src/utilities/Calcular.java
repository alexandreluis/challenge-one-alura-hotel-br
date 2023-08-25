package utilities;



public class Calcular 
{
	public Long calculaTempoEmDias(Long tempoEmMilissegundos)
	{
		return tempoEmMilissegundos /1000 /60 /60 /24;
	}
}