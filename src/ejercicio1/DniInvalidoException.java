package ejercicio1;

public class DniInvalidoException extends RuntimeException{

	public DniInvalidoException() {}

	@Override
	public String getMessage() {
		return "El DNI es inv�lido, asegurese de que solo contenga letras.";				
	}
	
}
