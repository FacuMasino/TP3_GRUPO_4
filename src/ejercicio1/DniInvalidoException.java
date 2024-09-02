package ejercicio1;

public class DniInvalidoException extends RuntimeException
{
	public DniInvalidoException()
	{
		
	}

	@Override
	public String getMessage()
	{
		return "El DNI es invalido, asegurese de que solo contenga numeros.";				
	}
}
