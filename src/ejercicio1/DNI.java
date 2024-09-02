package ejercicio1;

public class DNI
{
	public DNI()
	{
		
	}
	
	// Los numeros 0-9 estan entre los codigos ASCII 48 y 57 (Ver https://www.ascii-code.com/)
	private static boolean esNumero(char c)
	{
		if((int)c >= 48 && (int)c <= 57)
		{
			return true;
		}

		return false;
	}
	
	// Recorre cada caracter de nroDNI y verifica si es numero
	public static boolean verificarDniInvalido(String nroDNI) throws DniInvalidoException
	{		
		int ContadorInvalidos = 0;
		
		for (int i=0; i<nroDNI.length(); i++)
		{
			if (!esNumero(nroDNI.charAt(i)))
			{
				ContadorInvalidos ++;
			}
		}
		
		if (ContadorInvalidos>0)
		{
			DniInvalidoException excDni = new DniInvalidoException();
			throw excDni;
		}
		
		if (ContadorInvalidos == 0)
		{
			return true;
		}
		
		return false; 
	}
}
