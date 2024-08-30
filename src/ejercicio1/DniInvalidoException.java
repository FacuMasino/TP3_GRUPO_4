package ejercicio1;

public class DniInvalidoException extends RuntimeException{

	public DniInvalidoException() {}

	@Override
	public String getMessage() {
		return "El DNI es inválido, asegurese de que solo contenga letras.";				
	}
	
}
