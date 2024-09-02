package ejercicio1;

import java.io.IOException;

public class DniInvalidoException extends IOException
{
	private static final long serialVersionUID = 1L;

	public DniInvalidoException()
	{
		
	}

	@Override
	public String getMessage()
	{
		return "El DNI es invalido, asegurese de que solo contenga numeros.";				
	}
}
