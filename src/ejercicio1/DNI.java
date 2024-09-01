package ejercicio1;

public class DNI {

	public DNI() {
		// TODO Auto-generated constructor stub
	}
	
	private static boolean esNumero(char c) {
		// Seg�n la tabla de c�digos ASCII los n�meros 0-9 est�n entre
		// los c�digos de caracter 48 y 57. Ver https://www.ascii-code.com/
		if((int)c >= 48 && (int)c <= 57) {
			return true;
		}
		return false;
	}
	
	public static boolean verificarDniInvalido(String nroDNI) throws DniInvalidoException {
		// Recorrer cada caracter de la cadena nroDNI y verificar si es n�mero
		// utilizando la funcion esNumero()
		
		int ContadorInvalidos = 0;
		
		for (int i=0; i<nroDNI.length(); i++)
		{
			if (!esNumero(nroDNI.charAt(i))) {ContadorInvalidos ++;}
		}
		
		if (ContadorInvalidos>0) {
			
			  DniInvalidoException  excDni  = new DniInvalidoException();
			   throw excDni;
		}
		if (ContadorInvalidos == 0) {
			return true;
			  
		}	
		return false; 

}

	
	
}

